package com.reiser.homework.other;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Random;

/**
 * @author: reiserx
 * Date:2020/11/5
 * Des: 布隆过滤器
 */
public class BloomFilter {
    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(3, 50);
        bloomFilter.add("aaaa");
        System.out.println(bloomFilter.contains("aaaa"));
        System.out.println(bloomFilter.contains("bava"));
    }

    private BitSet hashes;
    private RandomInRange prng;
    private int k;
    private static final double LN2 = 0.6931471805599453; // ln(2)


    public BloomFilter(int n, int m) {
        k = (int) Math.round(LN2 * m / n);
        if (k <= 0) {
            k = 1;
        }
        this.hashes = new BitSet(m);
        this.prng = new RandomInRange(m, k);
    }

    public void add(Object o) {
        prng.init(o);
        for (RandomInRange r : prng) {
            hashes.set(r.value);
        }
    }

    public boolean contains(Object o) {
        prng.init(o);
        for (RandomInRange r : prng) {
            if (!hashes.get(r.value)) {
                return false;
            }
        }
        return true;
    }


    private static class RandomInRange
            implements Iterable<RandomInRange>, Iterator<RandomInRange> {

        private Random prng;
        private int max; // Maximum value returned + 1
        private int count; // Number of random elements to generate
        private int i = 0; // Number of elements generated
        public int value; // The current value

        RandomInRange(int maximum, int k) {
            max = maximum;
            count = k;
            prng = new Random();
        }

        public void init(Object o) {
            prng.setSeed(o.hashCode());
        }

        @Override
        public Iterator<RandomInRange> iterator() {
            i = 0;
            return this;
        }

        @Override
        public RandomInRange next() {
            i++;
            value = prng.nextInt() % max;
            if (value < 0) value = -value;
            return this;
        }

        @Override
        public boolean hasNext() {
            return i < count;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

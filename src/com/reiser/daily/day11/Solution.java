package com.reiser.daily.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: reiserx
 * Date:2020/9/17
 * Des:
 */
class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
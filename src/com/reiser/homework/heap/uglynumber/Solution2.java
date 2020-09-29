package com.reiser.homework.heap.uglynumber;

/**
 * @author: reiserx
 * Date:2020/9/20
 * Des:剑指 Offer 49. 丑数
 * 动态规划解题
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2=new Solution2();
        System.out.println(solution2.nthUglyNumber(10));
    }
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (n2 == dp[i]) {
                a++;
            }
            if (n3 == dp[i]) {
                b++;
            }
            if (n5 == dp[i]) {
                c++;
            }
        }
        return dp[n - 1];
    }

//    public int nthUglyNumber(int n) {
//        int a = 0, b = 0, c = 0;
//        int[] dp = new int[n];
//        dp[0] = 1;
//        for(int i = 1; i < n; i++) {
//            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
//            dp[i] = Math.min(Math.min(n2, n3), n5);
//            if(dp[i] == n2) a++;
//            if(dp[i] == n3) b++;
//            if(dp[i] == n5) c++;
//        }
//        return dp[n - 1];
//    }

}

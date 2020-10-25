package com.reiser.homework.dp._887;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/10/21
 * Des:
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.superEggDrop(4, 5000));;
    }

    Map<String, Integer> memo = new HashMap();

    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    private int dp(int K, int N) {
        if (!memo.containsKey(N + "|" + K)) {
            int ans = Integer.MAX_VALUE;
            if (N == 0) {
                ans = 0;
            } else if (K == 1) {
                ans = N;
            } else {
                for (int i = 1; i < N + 1; i++) {
                    ans = Math.min(ans, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1);
                }
            }
            memo.put(N + "|" + K, ans);
        }
        return memo.get(N + "|" + K);
    }
}

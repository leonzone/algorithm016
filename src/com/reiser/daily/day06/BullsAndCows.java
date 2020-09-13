package com.reiser.daily.day06;

/**
 * @author: reiserx
 * Date:2020/9/12
 * Des:猜数字游戏
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 */
public class BullsAndCows {
    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        bullsAndCows.getHint("123", "123");
    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            //TODO
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) {
                bulls++;
            } else {
                if (nums[s]++ < 0) {
                    cows++;
                }
                if (nums[g]-- > 0) {
                    cows++;
                }

            }

        }
        return bulls + "A" + cows + "B";
    }
}

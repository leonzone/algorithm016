https://leetcode.com/problems/plus-one/

加一

```java
public class PlusOne {

    public static void main(String[] args) {
        PlusOne2 solution = new PlusOne2();
        int[] nums = {9, 9, 9};
        int[] newnums = solution.plusOne(nums);
        for (int num : newnums) {
            System.out.println(num);
        }
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
```
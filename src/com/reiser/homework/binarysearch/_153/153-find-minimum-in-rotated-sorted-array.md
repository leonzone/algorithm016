[153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

旋转有序数组的二分查找，其实就是在二分查找的基础上和左右边界的值进行比较，发现单调性的异常

```java
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            //使用位运算计算中间点
            int mid = low + ((high - low) >> 1);
            //
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return nums[low];
    }
}
```
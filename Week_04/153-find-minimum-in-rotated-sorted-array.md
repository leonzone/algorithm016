[153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

旋转有序数组的二分查找，其实就是在二分查找的基础上和左右边界的值进行比较，发现单调性的异常

```java
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        //TODO 为什么是 low < high 而不是 low <= high
        while (low < high) {
            //使用位运算计算中间点
            int mid = low + ((high - low) >> 1);
            //中间值比右边界小，说明右侧是单调递增的，最小值不在右侧
            if (nums[mid] < nums[high]) {
            //TODO 为什么是 high = mid 而不是 high = mid-1
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return nums[low];
    }
}
```
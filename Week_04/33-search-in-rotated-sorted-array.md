[33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

题解：

`[4,5,6,7,0,1,2]`





代码：
```java
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            //mid 左部分有序
            if (nums[low] <= nums[mid]) {
                //target 在 low 和 mid 之间
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    //target 在无序的右半部分
                    low = mid + 1;
                }
            } else {
                // 注意 <= 和 < 的条件
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }


        }

        return -1;
    }
}
```
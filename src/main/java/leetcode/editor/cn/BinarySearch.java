package leetcode.editor.cn;

/**
 * /**
 * 题目：二分查找
 * 题目编号：704
 * 时间：2023-08-30 16:41:28
 * 通过：true
 */
public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 左闭右闭区间
        public int search(int[] nums, int target) {
//        while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
//        if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，那么接下来要查找的左区间结束下标位置就是 middle - 1
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        // 左闭右开区间
        public int search2(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
//
// Related Topics 数组 二分查找 👍 1418 👎 0

package leetcode.editor.cn;

/**
 * 题目：搜索旋转排序数组
 * 题目编号：33
 * 时间：2023-09-25 18:41:18
 * 通过：？
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums, 0, nums.length - 1, target);

        }

        // 4,5,6,7,1,2,3
        private int binarySearch(int[] nums, int l, int r, int target) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return target;
            } else if (nums[mid] > target){
//                binarySearch()
            }
            return -1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
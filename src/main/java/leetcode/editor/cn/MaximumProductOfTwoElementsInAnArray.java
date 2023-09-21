package leetcode.editor.cn;

/**
 * 题目：数组中两元素的最大乘积
 * 题目编号：1464
 * 时间：2023-10-12 16:19:15
 * 通过：？
 */
public class MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfTwoElementsInAnArray().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            // 拓展： 如果数组中包含负数？
            int max1 = Integer.MIN_VALUE + 1, max2 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE, min2 = Integer.MIN_VALUE + 1;
            for (int num : nums) {
                // 找出最大的两个数
                if (num > max1) {
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max2 = num;
                }
                // 找出最小的两个数
                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }
            }
            return Math.max((min1 - 1) * (min2 - 1), (max1 - 1) * (max2 -1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
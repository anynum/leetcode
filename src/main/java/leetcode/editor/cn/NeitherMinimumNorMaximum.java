package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目：既不是最小值也不是最大值
 * 题目编号：2733
 * 时间：2023-10-12 18:01:25
 * 通过：？
 */
public class NeitherMinimumNorMaximum {
    public static void main(String[] args) {
        Solution solution = new NeitherMinimumNorMaximum().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNonMinOrMax(int[] nums) {
            if (nums.length < 3){
                return -1;
            }
            Arrays.sort(nums);
            return nums[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
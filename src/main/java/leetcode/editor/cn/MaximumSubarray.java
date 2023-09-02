package leetcode.editor.cn;

/**
 * 题目：最大子数组和
 * 题目编号：53
 * 时间：2023-09-03 17:30:59
 * 通过：？
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            /**
             * 1.dp[i],到nums[i]为止的最大子数组的和
             * 2.dp[i] = max(dp[i-1]+nums[i],nums[i])
             * 3.如果dp[i-1] + nums[i]小于nums[i]，则dp[i-1]小于0，则被丢弃，计数重新开始
             */
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }

            int sum = 0;
            int[] dp = new int[length];
            int max = dp[0] = nums[0];

            for (int i = 1; i < length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                if (max < dp[i]) {
                    max = dp[i];
                }
            }
            return max;

        }

        // 空间压缩
        public int maxSubArrayV3(int[] nums) {
            int length = nums.length;
            int a = 0;
            int max = nums[0];
            for (int num : nums) {
                a = Math.max(a + num, num);
                max = Math.max(max, a);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6283 👎 0

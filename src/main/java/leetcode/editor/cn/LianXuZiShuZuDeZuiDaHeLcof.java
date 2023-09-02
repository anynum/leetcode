package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目：连续子数组的最大和
 * 题目编号：剑指 Offer 42
 * 时间：2023-09-03 23:09:25
 * 通过：？
 */
public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            /**
             * dp[i]：连续到第i个数（包括第i个数）的连续子数组的最大值；
             * i:连续到第i个数
             * [-2,1]
             */
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(dp[i], max);
            }
            return max;
        }

        public int maxSubArrayV1(int[] nums) {
            /**
             * dp[i]：连续到第i个数（包括第i个数）的连续子数组的最大值；
             * i:连续到第i个数
             * [-2,1]
             */
            int[] dp = new int[nums.length];
            dp[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
//
// Related Topics 数组 分治 动态规划 👍 723 👎 0

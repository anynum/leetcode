package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目：打家劫舍 II
 * 题目编号：213
 * 时间：2023-09-03 17:36:17
 * 通过：？
 */
public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            // dp[i],抢劫 至 第i家，获得的金额，不一定要抢第i家
            // 抢劫第i家，则第i-1家不能被抢，抢劫的总金额为第i家的金额，加上抢劫前i-2家的总金额
            // 不抢劫第i家，则可以抢劫前i-1家，不一定抢第i-1家
            // 综上: dp[i] = Max(dp[i-2]+nums[i],dp[i-1])

            // 两种情况，1.抢劫第一家 2.不考虑最后一家
            int length = nums.length;
            int[] arr1 = Arrays.copyOfRange(nums, 0, length - 1);
            int[] arr2 = Arrays.copyOfRange(nums, 1, length);

            return Math.max(rob2(arr1), rob2(arr2));


        }

        private int rob2(int[] nums) {

            // dp[i],抢劫 至 第i家，获得的金额，不一定要抢第i家
            // 抢劫第i家，则第i-1家不能被抢，抢劫的总金额为第i家的金额，加上抢劫前i-2家的总金额
            // 不抢劫第i家，则可以抢劫前i-1家，不一定抢第i-1家
            // 综上: dp[i] = Max(dp[i-2]+nums[i],dp[i-1])

            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }

            int length = nums.length;
            int[] dp = new int[length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1442 👎 0

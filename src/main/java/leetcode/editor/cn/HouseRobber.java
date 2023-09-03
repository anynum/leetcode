package leetcode.editor.cn;

/**
 * 题目：打家劫舍
 * 题目编号：198
 * 时间：2023-09-03 17:34:50
 * 通过：？
 */
public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {

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


//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 2716 👎 0

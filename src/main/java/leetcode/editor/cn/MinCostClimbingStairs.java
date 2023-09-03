package leetcode.editor.cn;

/**
 * 题目：使用最小花费爬楼梯
 * 题目编号：746
 * 时间：2023-09-03 20:36:03
 * 通过：？
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {

            // 第一脚上去，可以跨一步或者两步，并且不需要消耗，爬上对应台阶上支付cost[i]才可继续上爬，爬上天台的那一步，不需要花费
            // dp下标表示，爬上第n级台阶所需的最小花费
            int[] dp = new int[cost.length + 1];
            dp[0] = 0;
            dp[1] = 0;

            for (int i = 2; i <= cost.length; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }

            return dp[cost.length];

        }

        /*
         * 动态规划：第N步的最小花费等与第N-1或N-2步的最小花费加上当前步的花费
         * */
        public int minCostClimbingStairs2(int[] cost) {
            int length = cost.length;
            int[] dp = new int[length];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < length; i++) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            }
            // 最后异步不需要花费，取倒数第一步和倒数第二步的最小值
            return Math.min(dp[length - 1], dp[length - 2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。 
//
// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 
//
// 请你计算并返回达到楼梯顶部的最低花费。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10,15,20]
//输出：15
//解释：你将从下标为 1 的台阶开始。
//- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
//总花费为 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1,100,1,1,1,100,1,1,100,1]
//输出：6
//解释：你将从下标为 0 的台阶开始。
//- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
//总花费为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
//
// Related Topics 数组 动态规划 👍 1311 👎 0

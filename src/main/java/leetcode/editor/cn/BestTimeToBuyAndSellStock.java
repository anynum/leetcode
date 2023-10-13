package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

/**
 * 题目：买卖股票的最佳时机
 * 题目编号：121
 * 时间：2023-09-03 20:46:31
 * 通过：true
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int length = prices.length;
            // dp[i][0] 表示第i天手上没有股票所获得的最大收益
            // dp[i][1] 表示第i天手上有股票所获得的最大收益
            int[][] dp = new int[length][2];
            // 第0天（其实是第一天），不购买股票
            dp[0][0] = 0;
            // 第0天，购买股票，那么收益即是负的第0天的价格
            dp[0][1] = -prices[0];

            for (int i = 1; i < length; i++) {
                /**
                 * 1.第i天手上没有股票，即在这一天卖出，或再此之前已经卖出，则收益等与：
                 *   第i-1天的收益（手上没有股票，在第i天之前已经卖掉了）和 第i-1天的收益加上第i天的股价（手上有股票，第i天卖掉）
                 * 2.第i天手上有股票，即再此之前已经买入，或者在第i天买入，则收益等与：
                 *   第i-1天的的收益（在第i天之前已经买入）和第i-1天的收益减去第i天的股价（在第i天买入）
                 */

                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // 题目只允许买卖一次，当购买时，即是第一次购买
                dp[i][1] = Math.min(dp[i - 1][1], -prices[i]);
            }

            System.out.println("dp = " + JSON.toJSONString(dp));
            return Math.max(dp[length - 1][0], dp[length - 1][1]);

        }

        public int numWays(int n) {
            if (n < 2) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n; i++) {
                dp[1] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 3130 👎 0

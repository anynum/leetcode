package leetcode.editor.cn;

/**
 * 题目：股票的最大利润
 * 题目编号：剑指 Offer 63
 * 时间：2023-09-03 23:12:33
 * 通过：？
 */
public class GuPiaoDeZuiDaLiRunLcof {
    public static void main(String[] args) {
        Solution solution = new GuPiaoDeZuiDaLiRunLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int length = prices.length;
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < length; i++) {
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, -prices[i]);
            }
            return Math.max(dp0, dp1);
        }

        public int maxProfitV2(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            /**
             * dp[i][k][l]
             * i:第i天
             * k:最大允许K次交易
             * l:0或1，表示是否持有股票
             */
            int[][] dp = new int[prices.length][2]; // k为常数
            int length = prices.length;

            dp[0][0] = 0; // 在第一天不买入
            dp[0][1] = -prices[0]; // 第一天买入
            /**
             * 状态转移方程：
             * 第i天不持有股票，则最大利润等与前一天不持有股票 和 前一天持有股票加上第i天的股票价格(即在第i天卖出，获利prices[i]）
             * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
             *
             * 第i天持有股票，则最大利润等与前一天不持有股票减去第i天的股票价格（即在第i天买入，需要花费prices[i]）， 和 前一天持有股票加上第i天的股票价格
             * dp[i][k][1] = max(dp[i-1][k][0] - prices[i], dp[i-1][k][1])
             */
            for (int i = 1; i < length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return Math.max(dp[length - 1][0], dp[length - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 10^5 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-
//stock/ 
//
// Related Topics 数组 动态规划 👍 368 👎 0

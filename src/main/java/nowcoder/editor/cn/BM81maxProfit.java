package nowcoder.editor.cn;
/**
 * nowcoder题目：买卖股票的最好时机(二)
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 17:51:34
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)
import java.util.*;


public class BM81maxProfit {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        // write code here
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

//nowcoder submit region end(Prohibit modification and deletion)

}

//假设你有一个数组prices，长度为n，其中prices[i]是某只股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益 1. 你可以多次买
//卖该只股票，但是再次购买前必须卖出之前的股票 2. 如果不能获取收益，请返回0 3. 假设买入卖出均无手续费 
// 数据范围： ， 要求：空间复杂度 ，时间复杂度 
// 进阶：空间复杂度 ，时间复杂度 
// Related Topics 贪心 动态规划 
//示例:
//输入:[8,9,2,5,4,7,1]
//输出:7
//

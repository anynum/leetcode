package nowcoder.editor.cn;
/**
 * nowcoder题目：买卖股票的最好时机(一)
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 10:48:51
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)
import java.util.*;


public class NC7maxProfit {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        int a = 0;
        int b = -prices[0];

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            // 当天卖出，或者一直未买入
            a = Math.max(a, prices[i] + b );
            // 当天买入，或者之前买入
            b = Math.max(b, -prices[i]);
        }
        return Math.max(a, b);
        // write code here
    }

    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            // 当天卖出，或者一直未买入
            dp[i][0] = Math.max(0, prices[i] + dp[i-1][1] );
            // 当天买入，或者之前买入
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        for (int[] nums : dp) {
            max = Math.max(Math.max(nums[0],nums[1]),max);
        }

        return max;
        // write code here
    }
//nowcoder submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        NC7maxProfit profit = new NC7maxProfit();
        int[] nums = {8,9,2,5,4,7,1};
        profit.maxProfit(nums);
    }
}


//假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益 1.你可以买入一次股票
//和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天 2.如果不能获取到任何利润，请返回0 3.假设买入卖出均无
//手续费
// 
// 数据范围： 
// 要求：空间复杂度 ，时间复杂度 
// 
// Related Topics 动态规划 贪心 
//示例:
//输入:[8,9,2,5,4,7,1]
//输出:5 
//

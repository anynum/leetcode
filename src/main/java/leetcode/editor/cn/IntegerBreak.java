package leetcode.editor.cn;

/**
 * 题目：整数拆分
 * 题目编号：343
 * 时间：2023-09-03 20:51:21
 * 通过：？
 */
public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak2(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {  // 一层循环遍历n
                for (int j = 1; j <= i - j; j++) {  // 二层循环按步长拆分
                    /**
                     * Math.max(dp[i - j] * j, (i - j) * j);
                     * i可以按步长从1开始拆分，拆分后的乘积为 (i - j) * j，如果拆分出来的另一个数还可以再拆分则乘积为dp[i - j] * j
                     * 结果取上述最大的。
                     * 因为dp[i] 会被重复赋值，所以需要加入dp[i]做比较，如果再次拆分后的乘积没有上一次的大，则不做替换
                     */
                    dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
                }

            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics 数学 动态规划 👍 1258 👎 0

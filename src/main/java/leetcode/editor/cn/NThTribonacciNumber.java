package leetcode.editor.cn;

/**
 * 题目：第 N 个泰波那契数
 * 题目编号：1137
 * 时间：2023-09-03 20:36:34
 * 通过：？
 */
public class NThTribonacciNumber {
    public static void main(String[] args) {
        Solution solution = new NThTribonacciNumber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {

            if (n <= 2) {
                return n;
            }

            int[] dp = new int[3];
            dp[1] = 1;
            dp[2] = 1;

            int sum = 0;

            for (int i = 3; i <= n; i++) {
                sum = dp[0] + dp[1] + dp[2];
                dp[0] = dp[1];
                dp[1] = dp[2];
                dp[2] = sum;

            }

            return dp[dp.length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//泰波那契序列 Tn 定义如下： 
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// 示例 2： 
//
// 输入：n = 25
//输出：1389537
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 37 
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 276 👎 0

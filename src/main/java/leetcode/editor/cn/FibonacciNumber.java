package leetcode.editor.cn;

/**
 * 题目：斐波那契数
 * 题目编号：509
 * 时间：2023-09-03 20:56:57
 * 通过：？
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            return n == 1 || n == 0 ? n : fib(n - 1) + fib(n - 2);
        }

        public int fib2(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        public int fib3(int n) {
            int[] dp = new int[2];
            dp[0] = 0;
            dp[1] = 1;
            int sum = 0;

            for (int i = 2; i <= n; i++) {
                sum = dp[0] + dp[1];
                dp[0] = dp[1];
                dp[1] = sum;
            }
            return n < 2 ? n : sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 685 👎 0

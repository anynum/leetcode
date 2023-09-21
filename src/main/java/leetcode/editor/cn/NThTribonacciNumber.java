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
        // 空间压缩
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

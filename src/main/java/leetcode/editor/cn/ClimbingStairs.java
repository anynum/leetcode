package leetcode.editor.cn;

/**
 * 题目：爬楼梯
 * 题目编号：70
 * 时间：2023-09-03 20:44:24
 * 通过：true
 */
public class ClimbingStairs{
  public static void main(String[] args) {
       Solution solution = new ClimbingStairs().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      /**
       * 爬到第N层可以有两种途径
       * 1.爬到第N-1层再跨一级台阶
       * 2.爬到第N-2层跨两级台阶
       */
      public int climbStairs(int n) {
          int[] dp = new int[n + 1];
          dp[0] = 1;
          dp[1] = 1;
          dp[2] = 2;

          for (int i = 2; i <= n; i++) {
              dp[i] = dp[i - 1] + dp[i - 2];
          }

          return dp[n];
      }

      /**
       *
       * 动态规划压缩
       */
      public int climbStairs2(int n) {
          int a = 1;
          int b = 1;
          int sum = 0;
          for (int i = 2; i <= n; i++) {
              sum = a + b;
              a = b;
              b = sum;
          }
          return n < 2 ? 1 : sum;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3220 👎 0

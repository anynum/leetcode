package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 题目：丑数 II
 * 题目编号：264
 * 时间：2023-09-03 20:50:48
 * 通过：？
 */
public class UglyNumberIi{
  public static void main(String[] args) {
       Solution solution = new UglyNumberIi().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int nthUglyNumber1(int n) {
          /**
           * Long是因为溢出，因为x为Integer，但是3X,5X不一定是Integer
           */
          PriorityQueue<Long> queue = new PriorityQueue<>();
          queue.add(1L);
          long ans = 1;
          long tmp = 0;
          for (int i = 1; i <= n; i++) {
              ans = queue.poll();
              while (ans == tmp) {
                  ans = queue.poll();
              }
              tmp = ans;
              queue.add(ans * 3L);
              queue.add(ans * 5L);
              queue.add(ans * 7L);
          }
          return (int) ans;
      }

      public int nthUglyNumber2(int n) {
          int[] ans = new int[n+1];
          ans[0] = 1;
          for (int idx3 = 0, idx5 = 0, idx7 = 0, i = 1; i < n; i++) {
              int a = ans[idx3] * 3, b = ans[idx5] * 5, c = ans[idx7] * 7;
              int min = Math.min(a, Math.min(b, c));
              if (min == a) idx3++;
              if (min == b) idx5++;
              if (min == c) idx7++;
              ans[i] = min;
          }
          return ans[n - 1];
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 1100 👎 0

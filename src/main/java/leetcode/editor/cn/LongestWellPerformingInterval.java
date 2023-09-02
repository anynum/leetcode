package leetcode.editor.cn;

/**
 * 题目：表现良好的最长时间段
 * 题目编号：1124
 * 时间：2023-09-03 22:34:39
 * 通过：？
 */
public class LongestWellPerformingInterval{
  public static void main(String[] args) {
       Solution solution = new LongestWellPerformingInterval().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int longestWPI(int[] hours) {
          int a = 0, b = 0, max = 0;
          for (int i = 0; i < hours.length; i++) {
              if (hours[i] > 8) {
                  a = a + 1;
                  b++;
              } else {
                  if (--a <= 0) {
                      a = 0;
                      b = 0;
                  } else {
                      b++;
                  }
              }
              if (a > 0) {
                  max = Math.max(max, b);
              }
          }
          if (b > 0){
              max += b -1;
          }
          return max;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 495 👎 0

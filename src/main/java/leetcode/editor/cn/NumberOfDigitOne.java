package leetcode.editor.cn;

/**
 * 题目：数字 1 的个数
 * 题目编号：233
 * 时间：2023-09-03 20:49:39
 * 通过：？
 */
public class NumberOfDigitOne{
  public static void main(String[] args) {
       Solution solution = new NumberOfDigitOne().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int countDigitOne(int n) {
          int count = 0;
          while (n > 0){
              int i = countOne(n);
              count += i;
              n -= 1;
          }
          return count;
      }


      // 计算一个数字中1出现的次数
      private int countOne(int num){
          int cunt = 0;

          int i = num % 10;
          int p = num / 10;
          if (i == 1){
              cunt++;
          }
          if (p > 0){
              cunt += countOne(p);
          }
          return cunt;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 递归 数学 动态规划 👍 539 👎 0

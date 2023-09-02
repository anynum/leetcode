package leetcode.editor.cn;

/**
 * 题目：回文数
 * 题目编号：9
 * 时间：2023-09-03 17:29:43
 * 通过：？
 */
public class PalindromeNumber{
  public static void main(String[] args) {
       Solution solution = new PalindromeNumber().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public boolean isPalindromeV(int x) {
          if(x < 0)
              return false;
          int cur = 0;
          int num = x;
          while(num != 0) {
              cur = cur * 10 + num % 10;
              num /= 10;
          }
          return cur == x;
      }


      public boolean isPalindromeV2(int x) {
          StringBuilder stringBuilder = new StringBuilder(x+"");
          StringBuilder reverse = stringBuilder.reverse();
          try {
              int integer = Integer.parseInt(reverse.toString());
              return integer == x;
          }catch (Exception e){
              e.printStackTrace();
          }
          return false;
      }

      public boolean isPalindromeV1(int x) {
          String a = x + "";
          char[] chars = a.toCharArray();
          if (a.length() == 1){
              return true;
          }
          int left = 0, right = a.length() - 1;
          while (left < right) {
              if (chars[left] != chars[right]) {
                  return false;
              }
              left++;
              right--;
          }
          return true;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2652 👎 0

package leetcode.editor.cn;

/**
 * 题目：统计星号
 * 题目编号：2315
 * 时间：2023-09-03 23:02:15
 * 通过：true
 */
public class CountAsterisks{
  public static void main(String[] args) {
       Solution solution = new CountAsterisks().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int countAsterisks(String s) {
          int length = s.length();
          boolean flag = true;
          int ans = 0;
          for (int i = 0; i < length; i++) {
              char c = s.charAt(i);
              if (flag && c == '*'){
                  ans++;
              }
              if (c == '|'){
                  flag = !flag;
              }
          }
          return ans;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。 
//
// 请你返回 不在 竖线对之间，s 中 '*' 的数目。 
//
// 注意，每个竖线 '|' 都会 恰好 属于一个对。 
//
// 
//
// 示例 1： 
//
// 输入：s = "l|*e*et|c**o|*de|"
//输出：2
//解释：不在竖线对之间的字符加粗加斜体后，得到字符串："l|*e*et|c**o|*de|" 。
//第一和第二条竖线 '|' 之间的字符不计入答案。
//同时，第三条和第四条竖线 '|' 之间的字符也不计入答案。
//不在竖线对之间总共有 2 个星号，所以我们返回 2 。 
//
// 示例 2： 
//
// 输入：s = "iamprogrammer"
//输出：0
//解释：在这个例子中，s 中没有星号。所以返回 0 。
// 
//
// 示例 3： 
//
// 输入：s = "yo|uar|e**|b|e***au|tifu|l"
//输出：5
//解释：需要考虑的字符加粗加斜体后："yo|uar|e**|b|e***au|tifu|l" 。不在竖线对之间总共有 5 个星号。所以我们返回 5 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母，竖线 '|' 和星号 '*' 。 
// s 包含 偶数 个竖线 '|' 。 
// 
//
// Related Topics 字符串 👍 53 👎 0

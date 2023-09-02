package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 题目：第一个只出现一次的字符
 * 题目编号：剑指 Offer 50
 * 时间：2023-09-03 23:10:51
 * 通过：？
 */
public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
  public static void main(String[] args) {
       Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public char firstUniqChar(String s) {
          HashMap<Character, Boolean> map = new HashMap<>();
          char[] chars = s.toCharArray();
          for (char aChar : chars) {
              map.put(aChar, map.containsKey(aChar));
          }
          for (char aChar : chars) {
              if (!map.get(aChar)) return aChar;
          }
          return ' ';
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
//
// Related Topics 队列 哈希表 字符串 计数 👍 351 👎 0

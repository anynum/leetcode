package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 题目：最长不含重复字符的子字符串
 * 题目编号：剑指 Offer 48
 * 时间：2023-09-03 23:10:24
 * 通过：？
 */
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof{
  public static void main(String[] args) {
       Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int lengthOfLongestSubstring(String s) {
          if (s==null || s.length() == 0) return 0;
          int length = s.length();
          int max = 1, tmp = 0;
          int[] dp = new int[length];
          dp[0] = 1;
          HashMap<Character, Integer> dict = new HashMap<>();
          dict.put(s.charAt(0), 0);
          for (int i = 1; i < length; i++) {
              char c = s.charAt(i);
              if (dict.containsKey(c)) {
                  tmp = Math.max(tmp, dict.get(c));
                  dp[i] = i - tmp;
              } else {
                  dp[i] = dp[i - 1] + 1;
              }
              dict.put(c, i);
              max = Math.max(dp[i], max);
          }
          return max;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 619 👎 0

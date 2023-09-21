package leetcode.editor.cn;

/**
 * 题目：最长回文子串
 * 题目编号：5
 * 时间：2023-09-15 17:12:20
 * 通过：true
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();

    }



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         *
         * dp[l][r] = true,
         *      s.charAt(l) =  s.charAt(r) && r-l < 2
         *      s.charAt(l) =  s.charAt(r) && dp[l+1][r-1]
         * dp[l][r] = false,
         *      others
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int length = s.length();
            int maxStart = 0;
            int maxEnd = 0;
            int maxLen = 0;
            boolean[][] dp = new boolean[length][length];
            dp[0][0] = false;
            for (int r = 1; r < length; r++) {
                for (int l = 0; l < r; l++) {
                    // l = r 并且l和r是相邻的两个字符 或者 l和r中间的字符是回文串；
                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;
                        if (r - l + 1 > maxLen) {
                            maxLen = r - l + 1;
                            maxStart = l;
                            maxEnd = r;
                        }
                    }
                }
            }
            return s.substring(maxStart, maxEnd + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6810 👎 0

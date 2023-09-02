package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：最长回文串
 * 题目编号：409
 * 时间：2023-09-03 20:54:43
 * 通过：？
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome1(String s) {
            char[] chars = s.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.merge(c, 1, Integer::sum);
            }

            int res = 0, sed = 0;
            for (Map.Entry<Character, Integer> kv : map.entrySet()) {
                Integer count = kv.getValue();
                int i = count % 2;
                // 取模余1的话就减掉
                res += count - i;
                if (i == 1) sed = 1;
            }
            return res + sed;
        }

        public int longestPalindrome(String s) {
            int[] chars = new int[58];
            for (char c : s.toCharArray()) {
                chars[c - 65] += 1;
            }

            int res = 0, sed = 0;
            for (int count : chars) {
                int m = count % 2;
                res += count - m;
                if (m == 1) sed = 1;
            }
            return res + sed;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输出:1
// 
//
// 示例 3： 
//
// 
//输入:s = "aaaaaccc"
//输出:7 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 550 👎 0

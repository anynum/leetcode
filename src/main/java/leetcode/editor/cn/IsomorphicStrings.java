package leetcode.editor.cn;

import java.util.Arrays;

/**
 * /**
 * 题目：同构字符串
 * 题目编号：205
 * 时间：2023-08-29 22:03:22
 * 通过：true
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        solution.isIsomorphic("aaabbbba","bbbaaaba");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] t2s = new char[128];
            char[] s2t = new char[128];
            for (int i = 0; i < s.length(); i++) {
                if (t2s[s.charAt(i)] != 0 && t2s[s.charAt(i)] != t.charAt(i)) {
                    return false;
                } else if (s2t[t.charAt(i)] != 0 && s2t[t.charAt(i)] != s.charAt(i)) {
                    return false;
                } else {
                    t2s[s.charAt(i)] = t.charAt(i);
                    s2t[t.charAt(i)] = s.charAt(i);
                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给定两个字符串 s 和 t ，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
//
// Related Topics 哈希表 字符串 👍 638 👎 0

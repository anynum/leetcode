package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 题目：强密码检验器 II
 * 题目编号：2299
 * 时间：2023-09-03 22:48:33
 * 通过：？
 */
public class StrongPasswordCheckerIi {
    public static void main(String[] args) {
        Solution solution = new StrongPasswordCheckerIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public final String spec = "!@#$%^&*()-+";

        public boolean strongPasswordCheckerII(String password) {
            if (password.length() < 8) return false;
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < spec.length(); i++) {
                set.add(spec.charAt(i));
            }
            char last = ' ';
            char[] chars = password.toCharArray();
            boolean lower = false;
            boolean upper = false;
            boolean digital = false;
            boolean spe = false;
            for (char c : chars) {
                if (c == last) return false;
                if (c >= 'a' && c <= 'z')
                    lower = true;
                if (c <= 'Z' && c >= 'A')
                    upper = true;
                if (set.contains(c))
                    spe = true;
                if (c <= '9' && c >= '0')
                    digital = true;
                last = c;
            }
            return lower && upper && digital && spe;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//如果一个密码满足以下所有条件，我们称它是一个 强 密码： 
//
// 
// 它有至少 8 个字符。 
// 至少包含 一个小写英文 字母。 
// 至少包含 一个大写英文 字母。 
// 至少包含 一个数字 。 
// 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。 
// 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。 
// 
//
// 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：password = "IloveLe3tcode!"
//输出：true
//解释：密码满足所有的要求，所以我们返回 true 。
// 
//
// 示例 2： 
//
// 输入：password = "Me+You--IsMyDream"
//输出：false
//解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
// 
//
// 示例 3： 
//
// 输入：password = "1aB!"
//输出：false
//解释：密码不符合长度要求。所以我们返回 false 。 
//
// 
//
// 提示： 
//
// 
// 1 <= password.length <= 100 
// password 包含字母，数字和 "!@#$%^&*()-+" 这些特殊字符。 
// 
//
// Related Topics 字符串 👍 46 👎 0

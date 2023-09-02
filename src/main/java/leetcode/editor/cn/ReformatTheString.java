package leetcode.editor.cn;

import java.util.Stack;

/**
 * 题目：重新格式化字符串
 * 题目编号：1417
 * 时间：2023-09-03 22:38:35
 * 通过：？
 */
public class ReformatTheString {
    public static void main(String[] args) {
        Solution solution = new ReformatTheString().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformat(String s) {
            char[] chars = s.toCharArray();
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();
            for (char c : chars) {
                if (c > 96) {
                    stack1.push(c);
                } else {
                    stack2.push(c);
                }
            }
            if (Math.abs(stack1.size() - stack2.size()) > 1) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            if (stack1.size() >= stack2.size()) {
                int length = stack2.size();
                for (int i = 0; i < length; i++) {
                    builder.append(stack1.pop());
                    builder.append(stack2.pop());
                }
                builder.append(stack1.pop());
            } else {
                int length = stack1.size();
                for (int i = 0; i < length; i++) {
                    builder.append(stack1.pop());
                    builder.append(stack2.pop());
                }
                builder.append(stack2.pop());
            }
            return builder.toString();
        }

        // laji
        public String reformatV1(String s) {
            char[] chars = s.toCharArray();
            StringBuilder builder = new StringBuilder();
            builder.append(chars[0]);
            // 上一个是什么类型的字符， true: 字母
            boolean flag = chars[0] > 96;
            // 如果第一个放进去的是字母，那么
            Stack<Character> stack = new Stack<>();
            for (int i = 1; i < chars.length; i++) {
                if (flag && chars[i] < 96) {
                    // 如果上一轮是字母，这一轮是数字
                    builder.append(chars[i]);
                    flag = false;
                    if (!stack.isEmpty()) {
                        builder.append(stack.pop());
                        flag = false;
                    }
                } else if (!flag && chars[i] > 96) {
                    builder.append(chars[i]);
                    flag = true;
                    if (!stack.isEmpty()) {
                        builder.append(stack.pop());
                        flag = true;
                    }
                } else if (flag && chars[i] > 96) {
                    stack.push(chars[i]);
                } else if (!flag && chars[i] < 96) {
                    stack.push(chars[i]);
                }
            }
            if (stack.isEmpty()) {
                return builder.toString();
            }
            if ((flag && stack.peek() < 96) || (!flag && stack.peek() > 96)) {
                builder.append(stack.pop());
            }
            return stack.isEmpty() ? builder.toString() : "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。 
//
// 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。 
//
// 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "a0b1c2"
//输出："0a1b2c"
//解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
// 
//
// 示例 2： 
//
// 输入：s = "leetcode"
//输出：""
//解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
// 
//
// 示例 3： 
//
// 输入：s = "1229857369"
//输出：""
//解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
// 
//
// 示例 4： 
//
// 输入：s = "covid2019"
//输出："c2o0v1i9d"
// 
//
// 示例 5： 
//
// 输入：s = "ab123"
//输出："1a2b3"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母和/或数字组成。 
// 
//
// Related Topics 字符串 👍 96 👎 0

package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 * 题目：括号
 * 题目编号：面试题 08.09
 * 时间：2023-08-03 16:54:55
 * 通过：true
 */
public class BracketLcci {
    public static void main(String[] args) {


        StringBuilder builder = new StringBuilder("asdfg");
        StringBuilder delete = builder.delete(builder.length() - 1, builder.length());
        System.out.println("delete = " + delete.toString());


        Solution solution = new BracketLcci().new Solution();
        List<String> strings = solution.generateParenthesis(4);
        System.out.println("strings = " + JSON.toJSONString(strings));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            char[] builder = new char[n * 2];
            int l = 0, r = 0;
            ArrayList<String> list = new ArrayList<>();
            loop(list, builder, l, r, n);
            return list;
        }

        private void loop(List<String> list, char[] builder, int l, int r, int n) {
            if (l > n || l < r) {
                return;
            }
            if (l == n && r == n) {
                list.add(new String(builder));
                return;
            }

            if (l >= r) {
                // 先加左括号
                builder[l + r] = '(';
                loop(list, builder, ++l, r, n);

                // 再加右括号
                builder[--l + r] = ')';
                loop(list, builder, l, ++r, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。 
//
// 说明：解集不能包含重复的子集。 
//
// 例如，给出 n = 3，生成结果为： 
//
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
//
// Related Topics 字符串 动态规划 回溯 👍 131 👎 0

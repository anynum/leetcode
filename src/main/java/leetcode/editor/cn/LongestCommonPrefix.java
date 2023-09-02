package leetcode.editor.cn;

/**
 * /**
 * 题目：最长公共前缀
 * 题目编号：14
 * 时间：2023-08-31 17:02:48
 * 通过：？
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length <= 1) {
                return strs[0];
            }
            String tmp = strs[0];
            for (int i = 1; i < strs.length; i++) {
                if (tmp.length() > strs[i].length()) {
                    String a = tmp;
                    tmp = strs[i];
                    strs[i] = a;
                }
                for (int j = 0; j < tmp.length(); j++) {
                    if (strs[i].charAt(j) != tmp.charAt(j)) {
                        tmp = tmp.substring(0, j);
                        break;
                    }
                }
            }
            return tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2891 👎 0

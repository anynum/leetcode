package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目：单词拆分
 * 题目编号：139
 * 时间：2023-09-03 20:47:15
 * 通过：？
 */
public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            HashSet<String> dict = new HashSet<>(wordDict);
            int length = s.length();
            return buildStr(dict, s, 0);
        }

        private boolean buildStr(Set<String> dict, String str, int start) {
            int length = str.length();
            // start = length则说明到了最后一个位置
            for (int j = length - 1; start > 0; j++) {
                String sub = str.substring(start, start - j);
                if (dict.contains(sub)) {
                    // 包含子串，则继续向后匹配
                    if (!buildStr(dict, str, start - j)) {
                        // 回溯，说明当前步长走不通，步长加一
                        continue;
                    }
                    return true;
                }
            }
            return start == length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2272 👎 0

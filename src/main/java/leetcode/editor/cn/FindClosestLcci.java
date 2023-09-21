package leetcode.editor.cn;

/**
 * /**
 * 题目：单词距离
 * 题目编号：面试题 17.11
 * 时间：2023-08-31 16:57:47
 * 通过：true
 */
public class FindClosestLcci {
    public static void main(String[] args) {
        Solution solution = new FindClosestLcci().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            int length = words.length;
            int index1 = -1;
            int index2 = -1;
            int min = length;
            for (int i = 0; i < length; i++) {
                if (word1.equals(words[i])) {
                    index1 = i;
                }
                if (word2.equals(words[i])) {
                    index2 = i;
                }

                if (index1 != -1 && index2 != -1) {
                    min = Math.min(min, Math.abs(index1 - index2));
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗? 
//
// 示例： 
//
// 
//输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
//
// Related Topics 数组 字符串 👍 105 👎 0

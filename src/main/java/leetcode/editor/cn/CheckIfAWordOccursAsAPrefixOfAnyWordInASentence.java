package leetcode.editor.cn;

/**
 * 题目：检查单词是否为句中其他单词的前缀
 * 题目编号：1455
 * 时间：2023-10-12 16:31:22
 * 通过：？
 */
public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public static void main(String[] args) {
        Solution solution = new CheckIfAWordOccursAsAPrefixOfAnyWordInASentence().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] words = sentence.split(" ");
            char[] sc = searchWord.toCharArray();
            for (int i = 0; i < words.length; i++) {
                if (match(words[i].toCharArray(), sc)) return i + 1;
            }
            return -1;
        }

        private boolean match(char[] sc, char[] mc) {
            for (int i = 0, p = 0; i < sc.length; i++) {
                if (sc[i] != mc[p]) return false;
                if (p == mc.length - 1) return true;
                p++;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
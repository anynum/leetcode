package leetcode.editor.cn;

/**
 * 题目：回文排列
 * 题目编号：面试题 01.04
 * 时间：2023-07-31 16:16:11
 */
public class PalindromePermutationLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromePermutationLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
            int length = s.length();
            int[] dict = new int[128];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                dict[c]++;
            }
            if (length % 2 == 0) {
                for (int num : dict) {
                    if (num % 2 != 0) return false;
                }
            } else {
                boolean flag = false;
                for (int i : dict) {
                    if (i % 2 == 1 && flag) {
                        return false;
                    } else if (i % 2 == 1) {
                        flag = true;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
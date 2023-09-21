package leetcode.editor.cn;

/**
 * 题目：验证回文串
 * 题目编号：125
 * 时间：2023-10-11 18:32:07
 * 通过：？
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = solution.isPalindrome(s);
        System.out.println("palindrome = " + palindrome);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            char[] chars = s.toLowerCase().toCharArray();
            int l = 0, r = s.length() - 1;
            while (l < r) {
                if (!(chars[l] <= '9' && chars[l] >= '0') && !(chars[l] >= 'a' && chars[l] <= 'z')) {
                    l++;
                    continue;
                }
                if (!(chars[r] <= '9' && chars[r] >= '0') && !(chars[r] >= 'a' && chars[r] <= 'z')) {
                    r--;
                    continue;
                }
                if (chars[l++] != chars[r--]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
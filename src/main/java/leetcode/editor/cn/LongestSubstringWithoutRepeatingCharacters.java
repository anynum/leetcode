package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 题目：无重复字符的最长子串
 * 题目编号：3
 * 时间：2023-10-08 18:12:39
 * 通过：？
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };
        String s = "abcabcaa";
        int length = solution.lengthOfLongestSubstring(s);
        System.out.println("length = " + length);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int l = 0, r = 0, maxLen = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for (; r < s.length(); r++) {
                Integer index = map.get(s.charAt(r));
                if (index != null && index >= l) { // *
                    maxLen = Math.max(maxLen, r - l);
                    l = index + 1;
                }
                map.put(s.charAt(r), r);
            }
            maxLen = Math.max(maxLen, r - l); // *
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
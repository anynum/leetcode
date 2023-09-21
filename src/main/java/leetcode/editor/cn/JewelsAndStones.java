package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 题目：宝石与石头
 * 题目编号：771
 * 时间：2023-10-12 16:02:36
 * 通过：？
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        Solution solution = new JewelsAndStones().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            int count = 0;
            int[] dict = new int[128];
            for (char c : jewels.toCharArray()) {
                dict[c] = 1;
            }
            for (char c : stones.toCharArray()) {
                count += dict[c];
            }
            return count;
        }

        public int numJewelsInStones2(String jewels, String stones) {
            int count = 0;
            HashSet<Character> dict = new HashSet<>();
            for (char c : jewels.toCharArray()) {
                dict.add(c);
            }
            for (char c : stones.toCharArray()) {
                if (dict.contains(c)) count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
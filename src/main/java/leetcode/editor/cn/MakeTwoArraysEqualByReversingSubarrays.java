package leetcode.editor.cn;

/**
 * 题目：通过翻转子数组使两个数组相等
 * 题目编号：1460
 * 时间：2023-10-12 18:09:41
 * 通过：？
 */
public class MakeTwoArraysEqualByReversingSubarrays {
    public static void main(String[] args) {
        Solution solution = new MakeTwoArraysEqualByReversingSubarrays().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {
            int[] dict = new int[1001];
            for (int i : target) {
                dict[i]++;
            }
            for (int i : arr) {
                if (dict[i] - 1 < 0) {
                    return false;
                }
                dict[i]--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
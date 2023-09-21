package leetcode.editor.cn;

/**
 * 题目：找出数组中的幸运数
 * 题目编号：1394
 * 时间：2023-09-03 22:37:34
 * 通过：？
 */
public class FindLuckyIntegerInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindLuckyIntegerInAnArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLucky(int[] arr) {
            int[] dict = new int[501];
            for (int i : arr) dict[i]++;
            for (int i = dict.length - 1; i >= 0; i--) {
                if (dict[i] == i) return i;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

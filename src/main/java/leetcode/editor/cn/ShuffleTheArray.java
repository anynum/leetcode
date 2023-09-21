package leetcode.editor.cn;

/**
 * 题目：重新排列数组
 * 题目编号：1470
 * 时间：2023-09-03 22:38:51
 * 通过：？
 */
public class ShuffleTheArray {
    public static void main(String[] args) {
        Solution solution = new ShuffleTheArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int p = n, i = 0, index = 0;
            int[] res = new int[2 * n];
            while (p < nums.length) {
                res[index++] = nums[i++];
                res[index++] = nums[p++];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


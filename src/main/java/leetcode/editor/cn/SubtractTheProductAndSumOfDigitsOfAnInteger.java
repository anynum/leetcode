package leetcode.editor.cn;

/**
 * 题目：整数的各位积和之差
 * 题目编号：1281
 * 时间：2023-10-12 17:50:00
 * 通过：？
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {
        Solution solution = new SubtractTheProductAndSumOfDigitsOfAnInteger().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subtractProductAndSum(int n) {
            int m = 1, s = 0;
            while (n != 0) {
                s += n % 10;
                m *= n % 10;
                n /= 10;
            }
            return m - s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
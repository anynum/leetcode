package leetcode.editor.cn;

/**
 * 题目：一维数组的动态和
 * 题目编号：1480
 * 时间：2023-09-03 22:39:13
 * 通过：？
 */
public class RunningSumOf1dArray {
    public static void main(String[] args) {
        Solution solution = new RunningSumOf1dArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] runningSum(int[] nums) {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = nums[i] + sum[i - 1];
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package leetcode.editor.cn;

/**
 * 题目：子数组最大平均数 I
 * 题目编号：643
 * 时间：2023-10-08 17:29:13
 * 通过：？
 */
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
        int[] nums1 = {1, 12, -5, -6, 50, 3};
//         int[] nums1 = {5 };
        // int[] nums2 = { };
        solution.findMaxAverage(nums1, 4);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double findMaxAverage(int[] nums, int k) {
            // 1.定义需要维护的变量
            int sum = 0;
            double avg = Integer.MIN_VALUE;
            // 2.定义窗口的首位
            int l = 0, r = 0;
            // 3.进入循环
            while (r < nums.length) {
                sum += nums[r];
                // 循环内判断降低了性能 ？
                if (r - l + 1 >= k) {
                    avg = Math.max(avg, (double) sum / k);
                    sum -= nums[l];
                    l++;
                }
                r++;
            }
            return avg;
        }

        public double findMaxAverage2(int[] nums, int k) {
            // 1.定义需要维护的变量
            int sum = 0;
            double avg = Integer.MIN_VALUE;
            // 2.定义窗口的首位
            int l = 0, r = k;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            avg = (double) sum / k;
            // 3.进入循环
            while (r < nums.length) {
                sum += nums[r];
                sum -= nums[l];
                avg = Math.max(avg, (double) sum / k);
                l++;
                r++;
            }
            return avg;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
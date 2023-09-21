package leetcode.editor.cn;

/**
 * 题目：长度最小的子数组
 * 题目编号：209
 * 时间：2023-10-08 18:29:16
 * 通过：true
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
         int[] nums1 = {2,3,1,2,4,3};
        // int[] nums2 = { };
        int i = solution.minSubArrayLen(7, nums1);
        System.out.println("i = " + i);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0, ans = Integer.MAX_VALUE;
            int l = 0, r = 0;
            for (; r <= nums.length && l <= r; ) {
                if (sum < target) {
                    if (r >= nums.length) break;
                    sum += nums[r];
                    r++;
                }
                if (sum >= target) {
                    ans = Math.min(ans, r - l);
                    sum -= nums[l];
                    l++;
                }
            }
            return ans > nums.length ? 0 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
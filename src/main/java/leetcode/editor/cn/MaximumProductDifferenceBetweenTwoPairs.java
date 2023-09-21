package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目：两个数对之间的最大乘积差
 * 题目编号：1913
 * 时间：2023-10-12 17:55:20
 * 通过：？
 */
public class MaximumProductDifferenceBetweenTwoPairs{
  public static void main(String[] args) {
       Solution solution = new MaximumProductDifferenceBetweenTwoPairs().new Solution();
       // int[] nums1 = { };
       // int[] nums2 = { };
       
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length -2] - nums[0] * nums[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
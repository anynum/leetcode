package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 题目：删除子数组的最大得分
 * 题目编号：1695
 * 时间：2023-10-09 23:48:37
 * 通过：true
 */
public class MaximumErasureValue{
  public static void main(String[] args) {
       Solution solution = new MaximumErasureValue().new Solution();
        int[] nums1 = {5,2,1,2,5,2,1,2,5};
       // int[] nums2 = { };
      int i = solution.maximumUniqueSubarray(nums1);
      System.out.println("i = " + i);


  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxScore = 0, score = 0;
        int l = 0, r= 0;
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (; r < nums.length; r++) {
            Integer index = dict.get(nums[r]);
            score += nums[r];
            if (index != null && index >= l ){
                while (l <= index){
                    score -= nums[l++];
                }
            }
            dict.put(nums[r], r);
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
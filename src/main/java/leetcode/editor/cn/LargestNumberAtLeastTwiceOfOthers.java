package leetcode.editor.cn;

/**
 * 题目：至少是其他数字两倍的最大数
 * 题目编号：747
 * 时间：2023-10-12 15:10:38
 * 通过：？
 */
public class LargestNumberAtLeastTwiceOfOthers{
  public static void main(String[] args) {
       Solution solution = new LargestNumberAtLeastTwiceOfOthers().new Solution();
       // int[] nums1 = { };
       // int[] nums2 = { };
       
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE + 1, min = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min){
                min = nums[i];
                if (min > max){
                    index = i;
                    int tmp = max;
                    max = min;
                    min = tmp;
                }
            }
        }
        return (max / 2) >= min ? index : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
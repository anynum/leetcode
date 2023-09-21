package leetcode.editor.cn;

/**
 * 题目：有序数组的平方
 * 题目编号：977
 * 时间：2023-10-12 16:58:06
 * 通过：？
 */
public class SquaresOfASortedArray{
  public static void main(String[] args) {
       Solution solution = new SquaresOfASortedArray().new Solution();
       // int[] nums1 = { };
       // int[] nums2 = { };
       
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        // 两种方式
        int[] ans = new int[nums.length];
        if(nums[0] >= 0){
            // 有负数
            for (int i = 0; i < nums.length; i++) {
                ans[i] = nums[i] * nums[i];
            }
        } else {
            // 无负数
            int l = 0, r = nums.length-1, cur = nums.length - 1;
            while (l <= r){
                if (Math.abs(nums[l]) >= Math.abs(nums[r])){
                    ans[cur--] = nums[l] * nums[l++];
                } else {
                    ans[cur--] = nums[r] * nums[r--];
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
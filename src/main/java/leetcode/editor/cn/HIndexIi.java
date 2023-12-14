package leetcode.editor.cn;

/**
 * 题目：H 指数 II
 * 题目编号：275
 * 时间：2023-10-30 16:11:43
 * 通过：？
 */
public class HIndexIi{
  public static void main(String[] args) {
       Solution solution = new HIndexIi().new Solution();
        int[] nums1 = { 0,1,3,4,5,6};
       // int[] nums2 = { };
      int i = solution.hIndex(nums1);
      System.out.println("i = " + i);

  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        int lenth = citations.length, l = 0, r = lenth -1;
        int ans = -1;
        while (l <= r){
            int mid = (l + r) / 2;
            int ref = lenth - r;
            if (ref >= citations[mid]){
                ans = ref;
                return mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
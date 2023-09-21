package leetcode.editor.cn;

/**
 * 题目：递枕头
 * 题目编号：2582
 * 时间：2023-09-26 16:23:16
 * 通过：true
 */
public class PassThePillow{
  public static void main(String[] args) {
       Solution solution = new PassThePillow().new Solution();
       // int[] nums1 = { };
       // int[] nums2 = { };
      solution.passThePillow(4, 5);
       
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int passThePillow(int n, int time) {
        int flag = -1;
        int cur = 1;
        for (int i = 0; i < time; i++) {
            if (cur == 1 || cur == n){
                flag = -flag;
            }
            cur += flag;
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
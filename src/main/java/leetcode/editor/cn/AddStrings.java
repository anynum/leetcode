package leetcode.editor.cn;

/**
 * 题目：字符串相加
 * 题目编号：415
 * 时间：2023-12-14 17:36:23
 * 通过：？
 */
public class AddStrings{
  public static void main(String[] args) {
       Solution solution = new AddStrings().new Solution();
       // int[] nums1 = { };
       // int[] nums2 = { };

      String s = solution.addStrings("111111", "999999");
      System.out.println("s = " + s);


  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = array1.length - 1, j = array2.length - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i >= 0 ? array1[i] - '0' : 0;
            int b = j >= 0 ? array2[j] - '0' : 0;
            int tmp = a + b + carry;
            carry = tmp / 10;
            builder.append(tmp % 10);
        }
        if (carry > 0){
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
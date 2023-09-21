package leetcode.editor.cn;

/**
 * 题目：IP 地址无效化
 * 题目编号：1108
 * 时间：2023-10-12 16:09:28
 * 通过：？
 */
public class DefangingAnIpAddress {
    public static void main(String[] args) {
        Solution solution = new DefangingAnIpAddress().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String defangIPaddr(String address) {
            return address.replace(".", "[.]");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
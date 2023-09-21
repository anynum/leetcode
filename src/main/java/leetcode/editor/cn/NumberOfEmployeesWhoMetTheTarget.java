package leetcode.editor.cn;

/**
 * 题目：满足目标工作时长的员工数目
 * 题目编号：2798
 * 时间：2023-10-12 17:53:08
 * 通过：？
 */
public class NumberOfEmployeesWhoMetTheTarget {
    public static void main(String[] args) {
        Solution solution = new NumberOfEmployeesWhoMetTheTarget().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
            int ans = 0;
            for (int i = 0; i < hours.length; i++) {
                if (hours[i] >= target) ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
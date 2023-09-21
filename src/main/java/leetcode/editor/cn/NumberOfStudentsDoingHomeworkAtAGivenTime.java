package leetcode.editor.cn;

/**
 * 题目：在既定时间做作业的学生人数
 * 题目编号：1450
 * 时间：2023-10-12 16:55:32
 * 通过：？
 */
public class NumberOfStudentsDoingHomeworkAtAGivenTime {
    public static void main(String[] args) {
        Solution solution = new NumberOfStudentsDoingHomeworkAtAGivenTime().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int ans = 0;
            for (int i = 0; i < startTime.length; i++) {
                if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
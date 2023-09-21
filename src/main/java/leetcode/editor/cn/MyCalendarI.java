package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：我的日程安排表 I
 * 题目编号：729
 * 时间：2023-09-26 17:43:01
 * 通过：？
 */
public class MyCalendarI {
    public static void main(String[] args) {
//        Solution solution = new MyCalendarI().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendar {

        List<int[]> calender = new ArrayList<>();
        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            for (int i = 0; i < calender.size(); i++) {
                int[] cal = calender.get(i);
                if ((start >= cal[0] && start < cal[1]) ||
                        (end > cal[0] && end < cal[1])  ||
                        (start <= cal[0] && end >=cal[1])
                ){
                    return false;
                }
            }
            calender.add(new int[]{start,end});
            return true;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
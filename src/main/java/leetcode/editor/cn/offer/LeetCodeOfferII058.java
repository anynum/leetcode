package leetcode.editor.cn.offer;

import java.util.LinkedHashMap;

/*  */
public class LeetCodeOfferII058 {
    public static void main(String[] args) {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendar {
        byte[] bitmap;
        public MyCalendar() {
            bitmap= new byte[1000000000];
        }

        public boolean book(int start, int end) {
            for (int i = start; i < end; i++) {
                if (bitmap[i] == 1) return false;
            }

            for (int i = start; i < end; i++) {
                bitmap[i] = 1;
            }

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

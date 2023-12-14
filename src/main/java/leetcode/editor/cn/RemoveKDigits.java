package leetcode.editor.cn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

/**
 * 题目：移掉 K 位数字
 * 题目编号：402
 * 时间：2023-11-01 23:46:33
 * 通过：？
 */
public class RemoveKDigits {
    public static void main(String[] args) {
//        Solution solution = new RemoveKDigits().new Solution();
//        // int[] nums1 = { };
//        // int[] nums2 = { };
//
//        HashMap<String, List<String>> map = new HashMap<>();

//        int count = 1;
//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("time:" + System.currentTimeMillis());
//            }
//        }, 0,10, TimeUnit.SECONDS);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");


        // 获取当前日期时间
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("currentDateTime = " + formatter.format(currentDateTime));
        // 获取十天前的日期时间
        LocalDateTime tenDaysAgo = currentDateTime.minusDays(11);
        System.out.println("tenDaysAgo = " + formatter.format(tenDaysAgo));




    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            LinkedList<Character> list = new LinkedList<>();
            char[] c = num.toCharArray();
            for (int i = 0; i < c.length; i++) {
                while (true){
                    Character peek = list.peek();
                    if (peek == null) {
                        break;
                    }
                }

            }
            return new String("sdaf");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
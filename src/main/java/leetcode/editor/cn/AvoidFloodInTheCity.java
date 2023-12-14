package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 题目：避免洪水泛滥
 * 题目编号：1488
 * 时间：2023-10-13 10:28:16
 * 通过：？
 */
public class AvoidFloodInTheCity {
    public static void main(String[] args) {
        Solution solution = new AvoidFloodInTheCity().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };

        HashMap<Integer, Integer> map = new HashMap<>();
        map.compute(10, (k, v) -> (v == null) ? 1 : v + 1);
        map.compute(10, (k, v) -> (v == null) ? 1 : v + 1);
        map.compute(10, (k, v) -> (v == null) ? 1 : v + 1);
        map.compute(10, (k, v) -> (v == null) ? 1 : v + 1);

        System.out.println(map.get(10));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] avoidFlood(int[] rains) {


            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * 题目：同积元组
 * 题目编号：1726
 * 时间：2023-10-27 10:06:25
 * 通过：？
 */
public class TupleWithSameProduct {
    public static void main(String[] args) {
        Solution solution = new TupleWithSameProduct().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tupleSameProduct(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    Integer compute = map.compute(nums[i] * nums[j], (k, v) -> v == null ? 1 : v + 1);
                    if (compute > 1){
//                        ans -= (compute -1) * (compute - 2);
//                        // -x*x + 3x -2 + x*x + x = 4* -2
//                        ans += compute * (compute+1);
                        ans += 4 * compute + 2;
                    }
                }
            }

//            for (Integer value : map.values()) {
//                if (value > 1) {
//                    ans += value * (value - 1);
//                }
//            }
            return ans << 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
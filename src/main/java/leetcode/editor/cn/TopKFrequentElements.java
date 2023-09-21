package leetcode.editor.cn;

import java.util.*;
import java.util.function.BiFunction;

/**
 * 题目：前 K 个高频元素
 * 题目编号：347
 * 时间：2023-09-27 15:13:58
 * 通过：true
 */
public class TopKFrequentElements{
  public static void main(String[] args) {
       Solution solution = new TopKFrequentElements().new Solution();
       // int[] nums1 = { };
       // int[] nums2 = { };
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int limit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k1, v) -> v == null ? 1 : ++v);
        }
        return map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(limit)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
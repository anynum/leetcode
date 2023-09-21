package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 题目：下一个更大元素 II
 * 题目编号：503
 * 时间：2023-09-22 14:04:20
 * 通过：true
 */
public class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        int[] nums = {1, 2, 1};
        int[] ints = solution.nextGreaterElements(nums);
        System.out.println("ints = " + JSON.toJSONString(ints));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];
            Arrays.fill(ans, -1);
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < 2 * len; i++) {
                Integer first = deque.peekFirst();
                while (first != null && nums[first % len] < nums[i % len]) {
                    ans[first] = nums[i%len];
                    deque.pollFirst();
                    first = deque.peekFirst();
                }
                deque.addFirst(i % len);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
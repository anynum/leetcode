package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * /**
 * 题目：滑动窗口最大值
 * 题目编号：239
 * 时间：2023-08-30 23:32:26
 * 通过：？
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        solution.maxSlidingWindow(nums,3);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            LinkedList<Integer> list = new LinkedList<>();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                max = Math.max(nums[i], max);
                list.addFirst(nums[i]);
            }

            int[] res = new int[nums.length - k + 1];
            int index = 0;
            for (int i = k; i < nums.length;) {
                res[index++] = max;
                while (list.removeLast() != max) {
                    max = Math.max(nums[i], max);
                    list.addFirst(nums[i++]);
                    res[index++] = max;
                }
                if (i < nums.length){
                    list.addFirst(nums[i++]);
                }
                int tmpMax = Integer.MIN_VALUE;
                for (int j = i - k + 1; j <= i; j++){
                    tmpMax = Math.max(tmpMax, nums[j]);
                }
                max = tmpMax;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2468 👎 0

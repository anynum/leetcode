package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目：将 x 减到 0 的最小操作数
 * 题目编号：1658
 * 时间：2023-09-03 22:40:02
 * 通过：？
 */
public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceXToZero().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            x = Arrays.stream(nums).sum() - x;
            int length = nums.length;
            int ans = length + 1;
            for (int i = 0, j = 0, s = 0; i < length; ++i) {
                s += nums[i];
                // 当和大于x时j指针前移，否则i指针一直前移
                while (j <= i && s > x) {
                    s -= nums[j++];
                }
                if (s == x) {
                    ans = Math.min(ans, length - (i - j + 1));
                }
            }
            return ans == length + 1 ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改
// 数组以供接下来的操作使用。 
//
// 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,6,7,8,9], x = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,20,1,1,3], x = 10
//输出：5
//解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 1 <= x <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 二分查找 前缀和 滑动窗口 👍 300 👎 0

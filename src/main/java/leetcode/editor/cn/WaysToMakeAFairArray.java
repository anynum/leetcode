package leetcode.editor.cn;

/**
 * 题目：生成平衡数组的方案数
 * 题目编号：1664
 * 时间：2023-09-03 22:40:35
 * 通过：？
 */
public class WaysToMakeAFairArray {
    public static void main(String[] args) {
        Solution solution = new WaysToMakeAFairArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToMakeFair(int[] nums) {
            int s1 = 0, s2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    s2 += nums[i];
                } else {
                    s1 += nums[i];
                }
            }

            int t1 = 0, t2 = 0;
            int v1 = 0, v2 = 0;
            int res = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    v2 = t2 + s1 - t1;
                    v1 = t1 + s2 - t2 - nums[i];
                    t2 += nums[i];
                } else {
                    v1 = t1 + s2 - t2;
                    v2 = t2 + s1 - t1 - nums[i];
                    t1 += nums[i];
                }
                if (v1 == v2) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。 
//
// 比方说，如果 nums = [6,1,7,4,1] ，那么： 
//
// 
// 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。 
// 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。 
// 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。 
// 
//
// 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。 
//
// 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,6,4]
//输出：1
//解释：
//删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
//删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
//删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
//删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
//只有一种让剩余数组成为平衡数组的方案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1]
//输出：3
//解释：你可以删除任意元素，剩余数组都是平衡数组。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：0
//解释：不管删除哪个元素，剩下数组都不是平衡数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 111 👎 0

package leetcode.editor.cn;

/**
 * /**
 * 题目：最大连续 1 的个数
 * 题目编号：485
 * 时间：2023-08-30 16:40:46
 * 通过：？
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnes().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0, p = 0;
            for (int num : nums) {
                if (num == 1) {
                    p++;
                } else {
                    max = Math.max(p, max);
                    p = 0;
                }
            }
            max = Math.max(p, max);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
// 
//
// 示例 2: 
//
// 
//输入：nums = [1,0,1,1,0,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1. 
// 
//
// Related Topics 数组 👍 405 👎 0

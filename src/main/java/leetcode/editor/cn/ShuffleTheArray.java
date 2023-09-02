package leetcode.editor.cn;

/**
 * 题目：重新排列数组
 * 题目编号：1470
 * 时间：2023-09-03 22:38:51
 * 通过：？
 */
public class ShuffleTheArray {
    public static void main(String[] args) {
        Solution solution = new ShuffleTheArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int p = n, i = 0, index = 0;
            int[] res = new int[2 * n];
            while (p < nums.length) {
                res[index++] = nums[i++];
                res[index++] = nums[p++];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。 
//
// 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,5,1,3,4,7], n = 3
//输出：[2,3,5,4,1,7] 
//解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4,4,3,2,1], n = 4
//输出：[1,4,2,3,3,2,4,1]
// 
//
// 示例 3： 
//
// 输入：nums = [1,1,2,2], n = 2
//输出：[1,2,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// nums.length == 2n 
// 1 <= nums[i] <= 10^3 
// 
//
// Related Topics 数组 👍 177 👎 0

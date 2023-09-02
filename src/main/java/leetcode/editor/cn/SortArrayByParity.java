package leetcode.editor.cn;

/**
 * 题目：按奇偶排序数组
 * 题目编号：905
 * 时间：2023-09-03 22:33:53
 * 通过：？
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParity().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int left = 0, right = 0, temp = 0;
            while (right < nums.length) {
                if (nums[right] % 2 == 0) {
                    if (left != right) {
                        temp = nums[right];
                        nums[right] = nums[left];
                        nums[left] = temp;
                    }
                    left++;
                }
                right++;
            }
            return nums;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。 
//
// 返回满足此条件的 任一数组 作为答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,1,2,4]
//输出：[2,4,3,1]
//解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
//
// Related Topics 数组 双指针 排序 👍 365 👎 0

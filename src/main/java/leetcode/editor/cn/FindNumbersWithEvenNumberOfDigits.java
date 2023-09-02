package leetcode.editor.cn;

/**
 * 题目：统计位数为偶数的数字
 * 题目编号：1295
 * 时间：2023-09-03 22:36:06
 * 通过：？
 */
public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        Solution solution = new FindNumbersWithEvenNumberOfDigits().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumbers(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                if (String.valueOf(num).length() % 2 == 0) {
                    ans++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [12,345,2,6,7896]
//输出：2
//解释：
//12 是 2 位数字（位数为偶数） 
//345 是 3 位数字（位数为奇数）  
//2 是 1 位数字（位数为奇数） 
//6 是 1 位数字 位数为奇数） 
//7896 是 4 位数字（位数为偶数）  
//因此只有 12 和 7896 是位数为偶数的数字
// 
//
// 示例 2： 
//
// 输入：nums = [555,901,482,1771]
//输出：1 
//解释： 
//只有 1771 是位数为偶数的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 500 
// 1 <= nums[i] <= 10^5 
// 
//
// Related Topics 数组 👍 85 👎 0

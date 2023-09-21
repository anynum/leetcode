package leetcode.editor.cn;

/**
 * 题目：可被三整除的偶数的平均值
 * 题目编号：2455
 * 时间：2023-10-12 18:05:22
 * 通过：？
 */
public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    public static void main(String[] args) {
        Solution solution = new AverageValueOfEvenNumbersThatAreDivisibleByThree().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int averageValue(int[] nums) {
            int sum = 0, count = 0;
            for (int num : nums) {
                if (num % 6 == 0) {
                    sum += num;
                    count++;
                }
            }
            return count > 0 ? sum / count : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
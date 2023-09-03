package leetcode.editor.cn;

/**
 * /**
 * 题目：有效的完全平方数
 * 题目编号：367
 * 时间：2023-08-30 16:40:05
 * 通过：true
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int x) {
            int left = 0, right = x;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long multi = (long) mid * mid; // 溢出
                if (multi == x) {
                    return true;
                } else if (multi < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }

        public boolean isPerfectSquare2(int num) {
            int left = 0;
            int right = num;
            while (left <= right){
                int mid = left + (right - left) / 2;
                long square = (long) mid * mid;
                if (square == num){
                    return true;
                } else if (square > num){
                    right = mid - 1;
                } else if (square < num){
                    left = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。 
//
// 不能使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
//解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
//解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 526 👎 0

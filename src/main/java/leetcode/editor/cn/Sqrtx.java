package leetcode.editor.cn;

/**
 * /**
 * 题目：x 的平方根
 * 题目编号：69
 * 时间：2023-08-30 16:39:24
 * 通过：true
 */
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int left = 0, right = x;
            int res = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long multi = (long) mid * mid; // 溢出
                if (multi == x) {
                    return mid;
                } else if (multi < x) {
                    res = mid; // 记录最大的平方小于x的数
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1421 👎 0

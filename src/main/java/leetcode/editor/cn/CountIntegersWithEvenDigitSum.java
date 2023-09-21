package leetcode.editor.cn;

/**
 * 题目：统计各位数字之和为偶数的整数个数
 * 题目编号：2180
 * 时间：2023-09-03 22:45:43
 * 通过：true
 */
public class CountIntegersWithEvenDigitSum {
    public static void main(String[] args) {
        Solution solution = new CountIntegersWithEvenDigitSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countEven(int num) {
            int ans = 0;
            for (int i = 2; i <= num; i++) {
                int sum = 0;
                int m = i;
                while (m > 0) {
                    sum += m % 10;
                    m /= 10;
                }
                if (sum % 2 == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。 
//
// 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 4
//输出：2
//解释：
//只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。    
// 
//
// 示例 2： 
//
// 
//输入：num = 30
//输出：14
//解释：
//只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是： 
//2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 1000 
// 
//
// Related Topics 数学 模拟 👍 73 👎 0

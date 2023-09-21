package nowcoder.editor.cn;
/**
 * nowcoder题目：连续子数组的最大和
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 16:53:57
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)

import java.util.*;


public class BM72FindGreatestSumOfSubArray {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        int[][] dp = new int[array.length][2];
        dp[0][0] = array[0];
        dp[0][1] = array[0];
        for (int i = 1; i < array.length; i++) {
            // 不要当前值的时候，需要持有一个到目前为止最大的值
            dp[i][0] = Math.max(array[i], Math.max(dp[i-1][0], dp[i-1][1]));
            // 要当前值
            dp[i][1] = Math.max(array[i], Math.max(dp[i-1][1] + array[i], array[i]));
        }
        return Math.max(dp[array.length-1][0], dp[array.length-1][1]);
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int a = array[0];
        int b = array[0];
        for (int i = 1; i < array.length; i++) {
            // 不要当前值的时候，需要持有一个到目前为止最大的值
            a = Math.max(array[i], Math.max(a, b));
            // 要当前值
            b = Math.max(array[i], Math.max(b + array[i], array[i]));
        }
        return Math.max(a, b);
    }
//nowcoder submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        BM72FindGreatestSumOfSubArray solution = new BM72FindGreatestSumOfSubArray();
        int[] nums = {1,-2,3,10,-4,7,2,-5};
        int i = solution.FindGreatestSumOfSubArray(nums);
        System.out.println("i = " + i);

    }
}

//输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。 数据范围: 
// 
// 
// 要求:时间复杂度为 ，空间复杂度为 进阶:时间复杂度为 ，空间复杂度为 
// 
// Related Topics 动态规划 贪心 
//示例:
//输入:[1,-2,3,10,-4,7,2,-5]
//输出:18
//

package nowcoder.editor.cn;
/**
 * nowcoder题目：打家劫舍(一)
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-11 17:34:34
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)

import java.util.*;


public class BM78rob {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int rob(int[] nums) {
        // write code here
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][0] + nums[i], nums[i]);
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
//nowcoder submit region end(Prohibit modification and deletion)

}

//你是一个经验丰富的小偷，准备偷沿街的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，即，如果偷了第一家，就不能再偷第二家；如果偷了第
//二家，那么就不能偷第一家和第三家。 给定一个整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
// 
// 数据范围：数组长度满足 ，数组中每个值满足 
// 
// Related Topics 动态规划 
//示例:
//输入:[1,2,3,4]
//输出:6 
//

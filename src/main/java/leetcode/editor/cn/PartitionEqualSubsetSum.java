package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

/**
 * 题目：分割等和子集
 * 题目编号：416
 * 时间：2023-09-03 20:55:44
 * 通过：？
 */
public class PartitionEqualSubsetSum{
  public static void main(String[] args) {
       Solution solution = new PartitionEqualSubsetSum().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      /**
       * 01背包问题  -- 二维DP数组
       * @param weight 物品重量
       * @param value 物品价值
       * @param bagsize 背包重量
       * @return
       */
      public int backpack(int[] weight, int[] value, int bagsize){
          // 物品数量
          int nums = weight.length;
          // dp数组，表示第i件物品放入容量为j的背包，获得的最大价值
          int[][] dp = new int[nums+1][bagsize+1];
          // dp初始化，当背包容量为0的时候，价值为0
          for (int i = 0; i < nums; i++) {
              dp[i][0] = 0;
          }

          // 先遍历物品，再遍历背包
          for (int i = 1; i <= nums; i++) { // 物品序号从1开始，防止下标越界。
              for (int k = 1; k <= bagsize; k++) { // 背包容量从1开始，为0时已经初始化
                  if (k < weight[i-1]){
                      // 背包容量小于当前物品容量，肯定放不进去
                      dp[i][k] = dp[i-1][k];
                  } else {
                      // 当前物品可以放进背包，但可以选择放或者不放，取最大价值
                      dp[i][k] = Math.max(dp[i-1][k], dp[i-1][k - weight[i-1]]+ value[i-1]);
                  }
              }
          }
          System.out.println(JSON.toJSONString(dp));
          return dp[nums][bagsize];
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1870 👎 0

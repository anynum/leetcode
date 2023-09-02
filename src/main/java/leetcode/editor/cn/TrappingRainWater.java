package leetcode.editor.cn;

/**
 * /**
 * 题目：接雨水
 * 题目编号：42
 * 时间：2023-08-31 21:04:03
 * 通过：true
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int res = 0;
            int[] maxLeft = new int[height.length];
            int[] maxRight = new int[height.length];
            maxLeft[0] = 0;
            maxRight[height.length - 1] = 0;
            for (int i = 1; i < height.length; i++) {
                maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
            }
            for (int i = height.length - 2; i >= 0; i--) {
                maxRight[i] = Math.max(maxRight[i + 1], height[i+1]);
            }
            for (int i = 1; i < height.length; i++) {
                if (height[i] < maxLeft[i] && height[i] < maxRight[i]){
                    res += (Math.min(maxLeft[i],maxRight[i]) - height[i]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4661 👎 0

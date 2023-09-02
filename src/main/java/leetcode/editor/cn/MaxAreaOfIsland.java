package leetcode.editor.cn;

/**
 * 题目：岛屿的最大面积
 * 题目编号：695
 * 时间：2023-09-03 22:28:10
 * 通过：？
 */
public class MaxAreaOfIsland{
  public static void main(String[] args) {
       Solution solution = new MaxAreaOfIsland().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int maxAreaOfIsland(int[][] grid) {
          int x = grid.length - 1;
          int y = grid[0].length - 1;
          int res = 0;
          for (int i = 0; i < x; i++) {
              for (int k = 0; k < y; k++) {
                  if (grid[i][k] == 1) {
                      res = Math.max(res, dfs(i, k, grid));
                  }
              }
          }
          return res;
      }

      private int dfs(int i, int k, int[][] grid) {
          // 此处递归，所以要进行边界处理
          if (i < 0 || k < 0 || i >= grid.length || k >= grid[0].length
                  || grid[i][k] == 0) {
              return 0;
          }
          // 沉岛,以免后续再遍历到；
          grid[i][k] = 0;
          int area = 1;
          // 向上
          area += dfs(i - 1, k, grid);
          // 向下
          area += dfs(i + 1, k, grid);
          // 向左
          area += dfs(i, k - 1, grid);
          // 向右
          area += dfs(i, k + 1, grid);
          return area;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 994 👎 0

package leetcode.editor.cn;

/**
 * 题目：岛屿数量
 * 题目编号：200
 * 时间：2023-09-03 20:48:14
 * 通过：？
 */
public class NumberOfIslands{
  public static void main(String[] args) {
       Solution solution = new NumberOfIslands().new Solution();
      char[][] nums = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int numIslands(char[][] grid) {
          int x = grid.length;
          int y = grid[0].length;
          int res = 0;
          for (int i = 0; i < x; i++) {
              for (int j = 0; j < y; j++) {
                  if (grid[i][j] == '1') {
                      res++;
                      dfs(i, j, grid);
                  }
              }
          }
          return res;
      }

      private void dfs(int i, int j, char[][] grid) {
          if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
              return;
          }
          grid[i][j] = '0';
          dfs(i - 1, j, grid);
          dfs(i + 1, j, grid);
          dfs(i, j - 1, grid);
          dfs(i, j + 1, grid);
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2277 👎 0

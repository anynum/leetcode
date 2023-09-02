package leetcode.editor.cn;

/**
 * 题目：最小路径和
 * 题目编号：64
 * 时间：2023-07-31 14:27:45
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int i = grid[1][2];

        solution.minPathSum(grid);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // 每次只能向下或者向右移动一步。
        public int minPathSum(int[][] grid) {
            int x = grid.length, y = grid[0].length;
            int[][] dp = new int[x][y];

            dp[0][0] = grid[0][0];
            for (int i = 1; i < y; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < x; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

            for (int i = 1; i < x; i++) {
                for (int j = 1; j < y; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[x - 1][y - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;

/**
 * 题目：礼物的最大价值
 * 题目编号：剑指 Offer 47
 * 时间：2023-09-03 23:09:53
 * 通过：？
 */
public class LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];

            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }


        public int maxValueV1(int[][] grid) {
            /**
             * dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]) + grid[x][y]
             */
            int x = grid.length;
            int y = grid[0].length;
            int[][] dp = new int[x][y];
            dp[0][0] = grid[0][0];

            for (int i = 1; i < y; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }

            for (int i = 1; i < x; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

            for (int i = 1; i < x; i++) {
                for (int k = 1; k < y; k++) {
                    int p1 = dp[i - 1][k];
                    int p2 = dp[i][k - 1];
                    int p3 = grid[i][k];
                    dp[i][k] = Math.max(dp[i - 1][k], dp[i][k - 1]) + grid[i][k];
                }
            }
            return dp[x - 1][y - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 520 👎 0

package leetcode.editor.cn;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * /**
 * 题目：迷路的机器人
 * 题目编号：面试题 08.02
 * 时间：2023-08-03 18:36:08
 * 通过：true
 */
public class RobotInAGridLcci {
    public static void main(String[] args) {
        Solution solution = new RobotInAGridLcci().new Solution();
        int[][] grid = {{0,0}};
        solution.pathWithObstacles(grid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // obstacleGrid = [[0,0]]
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            List<List<Integer>> list = new ArrayList<>();
            dfs(list, 0, 0, obstacleGrid);
            Collections.reverse(list);
            return list;
        }

        private boolean dfs(List<List<Integer>> list, int i, int j, int[][] grid) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) {
                return false;
            }
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                list.add(new ArrayList<Integer>() {{
                    add(i);
                    add(j);
                }});
                return true;
            }
            grid[i][j] = 1;
            // 只能向下和向右
            if (dfs(list, i, j + 1, grid) || dfs(list, i + 1, j, grid)) {
                list.add(new ArrayList<Integer>() {{
                    add(i);
                    add(j);
                }});
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角
//移动到右下角的路径。 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//解释: 
//输入中标粗的位置即为输出表示的路径，即
//0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角） 
//
// 说明：r 和 c 的值均不超过 100。 
//
// Related Topics 数组 动态规划 回溯 矩阵 👍 120 👎 0

package leetcode.editor.cn;

/**
 * 题目：统计有序矩阵中的负数
 * 题目编号：1351
 * 时间：2023-10-12 17:08:56
 * 通过：？
 */
public class CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new CountNegativeNumbersInASortedMatrix().new Solution();
        int[][] nums = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        solution.countNegatives(nums);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNegatives(int[][] grid) {
            /**
             * [[4, 3, 2,-1],
             * [ 3, 2, 1,-1],
             * [ 1, 1,-1,-2],
             * [-1,-1,-2,-3]]
             */
            int cur = grid[0].length - 1;
            int y = grid.length;
            int ans = 0;
            for (int x = 0; x < grid.length; x++) {
                while (cur >= 0 && grid[x][cur] < 0) {
                    ans += (y - x);
                    cur--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
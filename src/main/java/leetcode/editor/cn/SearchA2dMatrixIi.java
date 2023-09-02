package leetcode.editor.cn;

/**
 * 题目：搜索二维矩阵 II
 * 题目编号：240
 * 时间：2023-09-03 20:50:04
 * 通过：？
 */
public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int x = 0;
            int y = 1;
            int length = matrix[0].length;

            while (y < length && x < matrix.length) {
                if (matrix[x][length - y] == target) {
                    return true;
                } else if (matrix[x][length - y] > target) {
                    x++;
                } else {
                    y++;
                }
            }
            return false;
        }

        public String replaceSpace(String s) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    builder.append("%20");
                } else {
                    builder.append(s.charAt(i));
                }
            }

            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 1335 👎 0

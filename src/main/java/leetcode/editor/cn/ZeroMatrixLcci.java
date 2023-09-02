package leetcode.editor.cn;

import java.util.HashSet;

/**
 * /**
 * 题目：零矩阵
 * 题目编号：面试题 01.08
 * 时间：2023-08-31 16:56:15
 * 通过：true
 */
public class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            for (int i = 0; i < m; i++) { // 行
                for (int k = 0; k < n; k++) { // 列
                    if (matrix[i][k] == 0) {
                        rowSet.add(i);
                        colSet.add(k);
                    }
                }
            }

            for (Integer row : rowSet) {
                clearRow(row, matrix);
            }

            for (Integer col : colSet) {
                clearCol(col, matrix);
            }
        }

        private void clearRow(int row, int[][] matrix) {

            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }

        private void clearCol(int col, int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
//
// Related Topics 数组 哈希表 矩阵 👍 168 👎 0

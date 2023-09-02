package leetcode.editor.cn;

/**
 * /**
 * 题目：排序矩阵查找
 * 题目编号：面试题 10.09
 * 时间：2023-08-04 11:31:40
 * 通过：True
 */
public class SortedMatrixSearchLcci {
    public static void main(String[] args) {
        Solution solution = new SortedMatrixSearchLcci().new Solution();
//        int[][] matrix = {
//                {1,  4,  7, 11, 15},
//                {2,  5,  8, 12, 19},
//                {3,  6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };


        int[][] matrix = {
                {5, 6, 10, 14},
                {6, 10, 13, 18},
                {10, 13, 18, 19}
        };

        boolean b = solution.searchMatrix(matrix, 14);
        System.out.println("b = " + b);

    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // shabby测试用例
            if (matrix.length < 1 || matrix[0].length < 1) {
                return false;
            }
            return dfs(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
        }

        private boolean dfs(int[][] matrix, int target, int x1, int y1, int x2, int y2) {
            if (x1 > x2 || y1 > y2 || x1 < 0 || y1 < 0 || x2 > matrix.length || y2 > matrix[0].length) {
                return false;
            }
            int midx = (x1 + x2) / 2;
            int midy = (y1 + y2) / 2;
            if (matrix[midx][midy] == target) {
                return true;
            } else if (matrix[midx][midy] > target) {
                // 比matrix[midx][midy]小的区域分为两部分 （x1, y1）-> (x2, midy -1) && (x1, midy) -> (midx-1, y2)
                return dfs(matrix, target, x1, y1, x2, midy - 1) ||
                        dfs(matrix, target, x1, midy, midx - 1, y2);
            } else {
                // 比matrix[midx][midy]大的区域分为两部分 （midx + 1, y1） -> (x2, midy) && (x1, midy+1) -> (x2, y2)
                return dfs(matrix, target, midx + 1, y1, x2, midy) ||
                        dfs(matrix, target, x1, midy + 1, x2, y2);
            }
        }
    }

}


//给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 58 👎 0

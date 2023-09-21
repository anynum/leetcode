package leetcode.editor.cn;

import com.sun.security.auth.NTSidGroupPrincipal;

/**
 * 题目：搜索二维矩阵
 * 题目编号：74
 * 时间：2023-09-25 17:53:45
 * 通过：？
 */
public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        // int[] nums1 = { };
         int[][] nums2 = {{1}};
        boolean b = solution.searchMatrix(nums2, 3);
        System.out.println("b = " + b);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            return binarySearch(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
        }

        //每行中的整数从左到右按非递减顺序排列。
        //每行的第一个整数大于前一行的最后一个整数。
        private boolean binarySearch(int[][] matrix, int x1, int y1, int x2, int y2, int target) {
            if (x1 > x2 || y1 > y2){
                return false;
            }
            int midx = (x1 + x2) / 2;
            int midy = (y1 + y2) / 2;
            if (matrix[midx][midy] > target) {
                return binarySearch(matrix, x1, y1, midx - 1, y2, target) || binarySearch(matrix, midx, y1, midx, midy - 1, target);
            } else if (matrix[midx][midy] < target) {
                return binarySearch(matrix, midx + 1, y1, x2, y2, target) || binarySearch(matrix, midx, midy + 1, midx, y2, target);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
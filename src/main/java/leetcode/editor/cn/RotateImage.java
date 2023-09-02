package leetcode.editor.cn;

/**
 * /**
 * 题目：旋转图像
 * 题目编号：48
 * 时间：2023-08-01 21:20:25
 */
public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int x = matrix.length;
            int y = matrix.length;
            for (int i = 0; i < (x + 1) / 2; i++) {
                for (int j = 0; j < x; j++) {
                    int tmp = matrix[i][j];
                    // 同一列
                    matrix[i][j] = matrix[x - i - 1][y]; // 0,0 -> 0,y-1
//                    matrix[x - i - 1][y] = matrix[]

                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
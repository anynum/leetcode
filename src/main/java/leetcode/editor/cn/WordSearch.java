package leetcode.editor.cn;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * /**
 * 题目：单词搜索
 * 题目编号：79
 * 时间：2023-08-03 18:05:09
 * 通过：true
 */
public class WordSearch {
    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";



        Solution solution = new WordSearch().new Solution();
        boolean exist = solution.exist(board, word);
        System.out.println("exist = " + exist);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean dfs = dfs(board, i, j, word, 0);
                    if (dfs) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        int x = board.length;
        int y = board[0].length;
        if (i >= x || i < 0 || j >= y || j < 0 || word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '0';
        // 上
        boolean t = dfs(board, i - 1, j, word, index + 1);
        // 下
        boolean d = dfs(board, i + 1, j, word, index + 1);
        // 左
        boolean l = dfs(board, i, j - 1, word, index + 1);
        // 右
        boolean r = dfs(board, i, j + 1, word, index + 1);

        board[i][j] = tmp;
        return l || r || t || d;
    }


        public boolean exist2(char[][] board, String word) {
            int index = 0;

            int m = board.length;
            int n = board[0].length;
            wia:
            for (int i = 0; i < m; i++) {
                for (int k = 0; k < n; k++) {
                    if (board[i][k] == word.charAt(index) ){
                        index++;
                        break wia;
                    }
                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 回溯 矩阵 👍 1638 👎 0

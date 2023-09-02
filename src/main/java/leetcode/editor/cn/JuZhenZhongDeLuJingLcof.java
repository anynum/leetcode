package leetcode.editor.cn;

/**
 * 题目：矩阵中的路径
 * 题目编号：剑指 Offer 12
 * 时间：2023-09-03 23:05:25
 * 通过：？
 */
public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int x = board.length;
            int y = board[0].length;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (dfs(i, j, 0, word, board)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int index, String word, char[][] board) {
            if (i < 0 || j < 0 || i > board.length || j > board[0].length
                    || board[i][j] != word.charAt(index)) {
                return false;
            }
            if (index == word.length() - 1) {
                return true;
            }
            // 沉岛
            board[i][j] = 0;
            boolean res = dfs(i - 1, j, index + 1, word, board)
                    || dfs(i + 1, j, index + 1, word, board)
                    || dfs(i, j - 1, index + 1, word, board)
                    || dfs(i, j + 1, index + 1, word, board);
            board[i][j] = word.charAt(index);
            return res;
        }


        public boolean existV1(char[][] board, String word) {
            char[] words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, words, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 领悟到了一丝DFS的奥妙
         */
        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            // 越界，或者当前字符不匹配下一个Word
            if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
                return false;
            }
            // 已匹配到最后一个Word, 并且board[i][j] = word[k]
            if (k == word.length - 1) {
                return true;
            }
            // 不是最后一个Word，标记当前位置已经访问过
            board[i][j] = '\0';

            // 按 下->上->右->左，深度优先搜索
            boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);

            // 回溯返回，取消标记
            board[i][j] = word[k];
            return res;
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
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
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
//输入：board = [["a","b"],["c","d"]], word = "abcd"
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
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
//
// Related Topics 数组 回溯 矩阵 👍 832 👎 0

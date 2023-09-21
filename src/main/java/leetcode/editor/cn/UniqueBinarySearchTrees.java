package leetcode.editor.cn;

/**
 * 题目：不同的二叉搜索树
 * 题目编号：96
 * 时间：2023-09-03 20:45:37
 * 通过：？
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dp = new int[19];
        // 递归 1 <= n <= 19
        public int numTrees(int n) {
            if (n == 1 || n == 0) {
                return 1;
            }

            if (dp[n] != 0) {
                return dp[n];
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                // i 作为root节点的时候
                // 左子树
                int left = numTrees(i - 1);
                // 右子树
                int right = numTrees(n - i);
                count += left * right;
            }

            dp[n] = count;
            return count;
        }

        // 动态规划
        public int numTrees2(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) { // 总共n个节点
                dp[i] = 0; // 为了方便理解，其实不用初始化
                for (int k = 1; k <= i; k++) { // 以K节点作为root节点时，1<= K <=i
                    // 当总共有i个节点，以第k个节点作为root节点时的二叉树的种数
                    int num = dp[k - 1] * dp[i - k];
                    dp[i] += num;
                }
            }
            return dp[n];
        }




    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2349 👎 0

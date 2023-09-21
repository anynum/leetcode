package leetcode.editor.cn;

import com.common.entity.TreeNode;
import leetcode.editor.cn.utils.LeetCodeUtils;

/**
 * 题目：从根到叶的二进制数之和
 * 题目编号：1022
 * 时间：2023-09-05 09:55:49
 * 通过：？
 */
public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfRootToLeafBinaryNumbers().new Solution();
        String numBin = "110011001";
        int i = Integer.parseInt(numBin, 2);
        System.out.println("i = " + i);

        Integer[] nums = {1, 0, 1, 0, 1, 0, 1};
        TreeNode treeNode = LeetCodeUtils.array2Tree(nums, 0);
        int i1 = solution.sumRootToLeaf(treeNode);
        System.out.println("sum = " + i1);
        System.out.println("treeNode = " + treeNode);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int sumRootToLeaf(TreeNode root) {
            int res = 0;
            StringBuilder builder = new StringBuilder();
            res = dfs(root, res, builder);
            return res;
        }

        private int dfs(TreeNode root, int res, StringBuilder builder) {
            if (root == null) {
                return 0;
            }
            builder.append(root.val);
            if (root.left == null && root.right == null) {
                //叶子节点, 求当前路径和
                res += Integer.parseInt(builder.toString(), 2);
                return res;
            }
            if (root.left != null) {
                res = dfs(root.left, res, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
            if (root.right != null) {
                res = dfs(root.right, res, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。 
//
// 
// 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。 
// 
//
// 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。 
//
// 返回这些数字之和。题目数据保证答案是一个 32 位 整数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 [1, 1000] 范围内 
// Node.val 仅为 0 或 1 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 239 👎 0

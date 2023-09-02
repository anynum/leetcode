package leetcode.editor.cn;

import leetcode.editor.cn.entity.TreeNode;

/**
 * 题目：平衡二叉树
 * 题目编号：剑指 Offer 55 - II
 * 时间：2023-09-01 16:27:03
 * 通过：？
 */
public class PingHengErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);

        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 380 👎 0

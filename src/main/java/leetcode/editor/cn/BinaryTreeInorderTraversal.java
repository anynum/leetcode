package leetcode.editor.cn;

import leetcode.editor.cn.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二叉树的中序遍历
 * 题目编号：94
 * 时间：2023-09-03 17:33:08
 * 通过：？
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {

            ArrayList<Integer> lis = new ArrayList<>();
            if (root == null) {
                return new ArrayList<Integer>();
            }

            lis.add(root.val);

            if (root.left != null) {
                inorder(root.left, lis);
            }
            if (root.right != null) {
                inorder(root.right, lis);
            }
            return lis;
        }

        private List<Integer> inorder(TreeNode root, List<Integer> list) {
            list.add(root.val);
            if (root.left != null) {
                inorder(root.left, list);
            }
            if (root.right != null) {
                inorder(root.right, list);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1899 👎 0

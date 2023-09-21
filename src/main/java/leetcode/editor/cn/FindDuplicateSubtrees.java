package leetcode.editor.cn;

import com.common.entity.TreeNode;

import java.util.List;

/**
 * 题目：寻找重复的子树
 * 题目编号：652
 * 时间：2023-09-03 21:47:35
 * 通过：？
 */
public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();

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
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {


            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一棵二叉树的根节点 root ，返回所有 重复的子树 。 
//
// 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。 
//
// 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在 [1, 5000] 范围内。 
// -200 <= Node.val <= 200 
// 
//
// Related Topics树 | 深度优先搜索 | 哈希表 | 二叉树 
//
// 👍 697, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

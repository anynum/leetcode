package leetcode.editor.cn;

import com.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：二叉树的层序遍历
 * 题目编号：102
 * 时间：2023-09-03 20:46:20
 * 通过：true
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> queue = new LinkedList();
            List<List<Integer>> list = new ArrayList();

            queue.add(root);
            while (!queue.isEmpty()) {
                // 每一层的节点数
                int levelNum = queue.size();
                ArrayList<Integer> subList = new ArrayList<>();

                for (int i = 0; i < levelNum; i++) {
                    TreeNode poll = queue.poll();
                    subList.add(poll.val);
                    if (poll.left != null) queue.offer(poll.left);
                    if (poll.right != null) queue.offer(poll.right);
                }

                list.add(subList);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1788 👎 0

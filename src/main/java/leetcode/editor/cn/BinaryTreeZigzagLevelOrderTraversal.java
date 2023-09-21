package leetcode.editor.cn;

import com.common.entity.TreeNode;
import leetcode.editor.cn.utils.LeetCodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：二叉树的锯齿形层序遍历
 * 题目编号：103
 * 时间：2023-09-26 16:47:14
 * 通过：？
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
         Integer[] nums1 = {1,2,3,4,null,null,5 };
        // int[] nums2 = { };
        TreeNode node = LeetCodeUtils.array2Tree(nums1, 0);

        solution.zigzagLevelOrder(node);


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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            boolean flag = true;
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(root);
            TreeNode node = null;
            List<List<Integer>> ans = new ArrayList<>();
            /**
             *            1     +
             *       2,         3   -
             *   4    null   null   5   +
             */
            while (!list.isEmpty()) {
                int size = list.size();
                List<Integer> levelNodes = new ArrayList<>();
                LinkedList<TreeNode> levelTreeNodes = new LinkedList<>();
                for (int i = 0; i < size; i++) {

                    if (flag) {
                        node = list.pollLast();
                        if (node.left != null) {
                            levelTreeNodes.addFirst(node.left);
                        }
                        if (node.right != null) {
                            levelTreeNodes.addFirst(node.right);
                        }
                    } else {
                        node = list.pollFirst();
                        if (node.right != null) {
                            levelTreeNodes.addFirst(node.right);
                        }
                        if (node.left != null) {
                            levelTreeNodes.addFirst(node.left);
                        }
                    }
                    levelNodes.add(node.val);
                }
                ans.add(levelNodes);
                flag = !flag;
                list = levelTreeNodes;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
package leetcode.editor.cn;

import com.common.entity.TreeNode;
import org.apache.commons.validator.Var;

import java.util.LinkedList;

/**
 * 题目：二叉树的最小深度
 * 题目编号：111
 * 时间：2023-09-26 16:37:09
 * 通过：？
 */
public class MinimumDepthOfBinaryTree{
  public static void main(String[] args) {
       Solution solution = new MinimumDepthOfBinaryTree().new Solution();
       // int[] nums1 = { };
       // int[] nums2 = { };
       
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int depth = 1;
        while (!list.isEmpty()){
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = list.pollLast();
                if (treeNode.left == null && treeNode.right == null){
                    return depth;
                }
                if (treeNode.left != null){
                    list.addFirst(treeNode.left);
                }
                if (treeNode.right != null){
                    list.addFirst(treeNode.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
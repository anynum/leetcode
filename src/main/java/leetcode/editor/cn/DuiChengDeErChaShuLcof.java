package leetcode.editor.cn;

import com.common.entity.TreeNode;

/**
 * 题目：对称的二叉树
 * 题目编号：剑指 Offer 28
 * 时间：2023-09-03 23:07:30
 * 通过：？
 */
public class DuiChengDeErChaShuLcof{
  public static void main(String[] args) {
       Solution solution = new DuiChengDeErChaShuLcof().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return compare(root.left, root.right);
        }
        return false;
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        } else if (left != null && right != null) {
            if (left.val != right.val) return false;
            return compare(left.left, right.right) && compare(left.right, right.left);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 / \ 2 2 / \ / \ 3 4 4 3 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 / \ 2 2 \ \ 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 470 👎 0

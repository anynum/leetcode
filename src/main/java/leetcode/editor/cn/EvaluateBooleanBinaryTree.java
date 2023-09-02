package leetcode.editor.cn;

import leetcode.editor.cn.entity.TreeNode;

/**
 * 题目：计算布尔二叉树的值
 * 题目编号：2331
 * 时间：2023-09-03 23:03:00
 * 通过：？
 */
public class EvaluateBooleanBinaryTree{
  public static void main(String[] args) {
       Solution solution = new EvaluateBooleanBinaryTree().new Solution();
       
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
    public boolean evaluateTree(TreeNode root) {
        if (root == null){
            return false;
        }
        switch (root.val){
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return evaluateTree(root.left) || evaluateTree(root.right);
            case 3:
                return evaluateTree(root.left) && evaluateTree(root.right);
            default:
                return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一棵 完整二叉树 的根，这棵树有以下特征： 
//
// 
// 叶子节点 要么值为 0 要么值为 1 ，其中 0 表示 False ，1 表示 True 。 
// 非叶子节点 要么值为 2 要么值为 3 ，其中 2 表示逻辑或 OR ，3 表示逻辑与 AND 。 
// 
//
// 计算 一个节点的值方式如下： 
//
// 
// 如果节点是个叶子节点，那么节点的 值 为它本身，即 True 或者 False 。 
// 否则，计算 两个孩子的节点值，然后将该节点的运算符对两个孩子值进行 运算 。 
// 
//
// 返回根节点 root 的布尔运算值。 
//
// 完整二叉树 是每个节点有 0 个或者 2 个孩子的二叉树。 
//
// 叶子节点 是没有孩子的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [2,1,3,null,null,0,1]
//输出：true
//解释：上图展示了计算过程。
//AND 与运算节点的值为 False AND True = False 。
//OR 运算节点的值为 True OR False = True 。
//根节点的值为 True ，所以我们返回 true 。 
//
// 示例 2： 
//
// 输入：root = [0]
//输出：false
//解释：根节点是叶子节点，且值为 false，所以我们返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在 [1, 1000] 之间。 
// 0 <= Node.val <= 3 
// 每个节点的孩子数为 0 或 2 。 
// 叶子节点的值为 0 或 1 。 
// 非叶子节点的值为 2 或 3 。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 83 👎 0

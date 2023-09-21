package leetcode.editor.cn;

import com.common.entity.TreeNode;

import java.util.ArrayList;

/**
 * 题目：恢复二叉搜索树
 * 题目编号：99
 * 时间：2023-09-21 17:35:06
 * 通过：true
 */
public class RecoverBinarySearchTree{
  public static void main(String[] args) {
       Solution solution = new RecoverBinarySearchTree().new Solution();
       
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

    TreeNode x = null;
    TreeNode y = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        TreeNode pre = new TreeNode(-1);

        inOrder(root);
        if (x != null && y != null){
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null){
            return;
        }
        inOrder(root.left);
        if (pre == null){
            // 给pre赋值的时候即是左下第一个节点
            pre = root;
        } else {
            /**
             * 中序遍历的时候，用pre记录前一个值，避免额外的空间消耗
             */
            if (pre.val > root.val ){
                y = root;
                if (x == null){
                    x = pre;
                }
            }
            pre = root;
        }
        inOrder(root.right);
    }


    /**
     * 中序遍历法
     * @param root
     */
    public void recoverTreeV1(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root,list );
        TreeNode x = null;
        TreeNode y = null;
        boolean flag = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i+1).val){
                /**
                 * 如果是相邻的两个数交换 1,2,3,4,5,6,7 -> 1,3,2,4,5,6,7
                 *      只会满足一次条件：x取前值，y取后值
                 * 如果是不相邻的两个数交换 1,2,3,4,5,6,7 -> 1,6,3,4,5,2,7
                 * 满足两次条件：
                 *      第一次：x取前值，y取后值
                 *      第二次：y取后值，覆盖之前的值，x不取值
                 * 后一种情况包含前一种
                 */
                y = list.get(i+1);
                if (x == null){
                    x = list.get(i);
                }
                // 加一个标志，找到两个节点后直接退出，不再遍历
                flag = !flag;
                if (flag){
                    break;
                }
            }
        }
        if (x != null && y != null){
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    private void inOrder(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 891 👎 0

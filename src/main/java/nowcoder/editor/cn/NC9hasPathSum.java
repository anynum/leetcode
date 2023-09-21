package nowcoder.editor.cn;
/**
 * nowcoder题目：二叉树中和为某一值的路径(一)
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 11:14:21
 * nowcoder通过：？
 */
import com.common.entity.TreeNode;
//nowcoder submit region begin(Prohibit modification and deletion)


/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class NC9hasPathSum {

    public boolean hasPathSum (TreeNode root, int target) {
        TreeNode cur = root;
        if (root == null){
            return false;
        }

        boolean res = dfs(root, 0, target);
        return res;

        // write code here
    }

    private boolean dfs(TreeNode root, int sum, int target) {
        if (root.left == null && root.right == null){
            return root.val + sum == target;
        }
        if (root.left != null){
            boolean left = dfs(root.left, sum + root.val, target);
            if (left) return true;
        }
        if (root.right != null){
            return dfs(root.right, sum + root.val, target);
        }
        return false;
    }
//nowcoder submit region end(Prohibit modification and deletion)

}

//给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
// 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点 2.叶子节点是指没有子节点的节点 3.路径只能从父节点到子节点，不能从子节点到父节点 4
//.总节点数目为n 
// 例如：
// 给出如下的二叉树，，
// 
// 返回true，因为存在一条路径 的节点值之和为 22 
// 
// 数据范围： 1.树上的节点数满足 2.每 个节点的值都满足 
// 要求：空间复杂度 ，时间复杂度 进阶：空间复杂度 ，时间复杂度 
// 
// Related Topics 树 dfs 
//示例:
//输入:{5,4,8,1,11,#,9,#,#,2,7},22
//输出:true
//

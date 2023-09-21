package nowcoder.editor.cn;
/**
 * nowcoder题目：二叉树中和为某一值的路径(二)
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 11:30:46
 * nowcoder通过：？
 */
import com.common.entity.TreeNode;
//nowcoder submit region begin(Prohibit modification and deletion)

import java.util.*;

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

public class NC8FindPath {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @param target int整型 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> FindPath (TreeNode root, int target) {
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> pathNums = new ArrayList<>();
        dfs(root, target, 0, list, pathNums);
        return list;
        // write code here
    }

    private void dfs(TreeNode root,int target, int sum,  ArrayList<ArrayList<Integer>> list, ArrayList<Integer> pathNums) {
        if (root.left == null && root.right == null){
            if (target == sum + root.val){
                ArrayList<Integer> tmp = new ArrayList<>(pathNums);
                tmp.add(root.val);
                list.add(tmp);
            }
        }
        pathNums.add(root.val);
        if (root.left != null){
            dfs(root.left, target, sum + root.val ,list, pathNums);
        };
        if (root.right != null){
            dfs(root.right, target, sum + root.val, list, pathNums);
        }
        pathNums.remove(pathNums.size() - 1);
    }


//nowcoder submit region end(Prohibit modification and deletion)

}

//输入一颗二叉树的根节点root和一个整数expectNumber，找出二叉树中结点值的和为expectNumber的所有路径。 1.该题路径定义为从树的根结
//点开始往下一直到叶子结点所经过的结点 2.叶子节点是指没有子节点的节点 3.路径只能从父节点到子节点，不能从子节点到父节点 4.总节点数目为n 
// 如二叉树root为{10,5,12,4,7},expectNumber为22 则合法路径有[[10,5,7],[10,12]]
// 
// 数据范围: 树中节点总数在范围 [0, 5000] 内 -1000 <= 节点值 <= 1000 -1000 <= expectNumber <= 100
//0 
// Related Topics 树 
//示例:
//输入:{10,5,12,4,7},22
//输出:[[10,5,7],[10,12]] 
//

package leetcode.editor.cn;

import leetcode.editor.cn.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：从上到下打印二叉树 II
 * 题目编号：剑指 Offer 32 - II
 * 时间：2023-09-03 23:08:14
 * 通过：？
 */
public class CongShangDaoXiaDaYinErChaShuIiLcof{
  public static void main(String[] args) {
       Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
       
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) queue.add(root);;
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-
//traversal/ 
//
// Related Topics 树 广度优先搜索 二叉树 👍 312 👎 0

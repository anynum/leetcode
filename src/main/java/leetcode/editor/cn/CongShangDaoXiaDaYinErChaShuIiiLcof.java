package leetcode.editor.cn;

import com.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：从上到下打印二叉树 III
 * 题目编号：剑指 Offer 32 - III
 * 时间：2023-09-03 23:08:27
 * 通过：true
 */
public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> list = new ArrayList<>();
            if (root != null) {
                queue.add(root);
            }
            ;
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> level = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (list.size() % 2 == 0) {
                        level.addLast(node.val);
                    } else {
                        level.addFirst(node.val);
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
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


//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 二叉树 👍 311 👎 0

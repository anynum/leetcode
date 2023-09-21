package leetcode.editor.cn;

import com.common.entity.TreeNode;

/**
 * 题目：最长同值路径
 * 题目编号：687
 * 时间：2023-09-05 09:56:07
 * 通过：？
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int result = 0;

        int ans = 0;

        public int longestUnivaluePath(TreeNode root) {
            calculate(root);
            return result;
        }

        // 深度优先
        public int calculate(TreeNode node) {
            if (node == null) return 0;
            int leftValue = calculate(node.left);
            int rightValue = calculate(node.right);

            leftValue = (node.left != null && node.val == node.left.val) ? ++leftValue : 0;
            rightValue = (node.right != null && node.val == node.right.val) ? ++rightValue : 0;

            result = Math.max(result, leftValue + rightValue);
            return Math.max(leftValue, rightValue);
        }

//        private int count(TreeNode node){
//            if (node == null){
//                return 0;
//            }
//            int leftValue = calculate(node.left);
//            int rightValue = calculate(node.right);
//
//
//
//            return 0;
//
//        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个二叉树的
// root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 
//
// 两个节点之间的路径长度 由它们之间的边数表示。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,4,5,1,1,5]
//输出：2

// 示例 2:
//
//输入：root = [1,4,5,4,4,5]
//输出：2
//
// 提示: 
//
// 
// 树的节点数的范围是
// [0, 10⁴] 
// -1000 <= Node.val <= 1000 
// 树的深度将不超过 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 777 👎 0

package leetcode.editor.cn;

import com.common.entity.TreeNode;

import java.util.ArrayList;

/**
 * 题目：二叉搜索树中第K小的元素
 * 题目编号：230
 * 时间：2023-09-04 10:01:54
 * 通过：？
 */
public class KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            TreeNode cur = root;
            ArrayList<Integer> list = new ArrayList<>();
            inOrder(cur, list, k);
            return list.get(k - 1);
        }

        // 二叉搜索树的中序遍历是正序，
        private void inOrder(TreeNode cur, ArrayList<Integer> list, int k) {
            if (cur == null){
                return;
            }
            inOrder(cur.left, list, k);
            if (list.size() == k){
                return;
            }
            list.add(cur.val);
            inOrder(cur.right, list, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 773 👎 0

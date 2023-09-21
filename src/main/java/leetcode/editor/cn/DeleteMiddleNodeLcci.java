package leetcode.editor.cn;

import com.common.entity.ListNode;

/**

/**
 * 题目：删除中间节点
 * 题目编号：面试题 02.03
 * 时间：2023-08-01 23:35:28
 */
public class DeleteMiddleNodeLcci{
  public static void main(String[] args) {
       Solution solution = new DeleteMiddleNodeLcci().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;

import com.common.entity.ListNode;

/**
 * 题目：合并两个排序的链表
 * 题目编号：剑指 Offer 25
 * 时间：2023-09-03 23:06:45
 * 通过：true
 */
public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode tmp = head;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    tmp.next = l1;
                    l1 = l1.next;
                } else {
                    tmp.next = l2;
                    l2 = l2.next;
                }
                tmp = tmp.next;
            }
            tmp.next = l1 == null ? l2 : l1;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
//
// Related Topics 递归 链表 👍 372 👎 0

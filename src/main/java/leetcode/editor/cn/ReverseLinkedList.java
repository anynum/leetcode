package leetcode.editor.cn;

import com.common.entity.ListNode;

/**
 * 题目：反转链表
 * 题目编号：206
 * 时间：2023-09-03 20:49:00
 * 通过：true
 */
public class ReverseLinkedList{
  public static void main(String[] args) {
       Solution solution = new ReverseLinkedList().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null|| head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 双指针
    public ListNode reverseListV2(ListNode head) {
        // 当前节点，先指向head
        ListNode cur = head;
        // 当前节点的前一个节点，初始化为null
        ListNode pre = null;
        // 临时节点，，用来保存当前节点的下一个节点。
        ListNode tmp = null;

        while(cur!=null) {
            // 保存当前节点的下一个节点
            tmp = cur.next;
            // 将当前节点指向前一个节点
            cur.next = pre;
            // pre和cur节点都后移一位
            pre = cur;
            cur = tmp;
        }
        // 当前节点为空退出循环，pre节点则为最后一个节点；
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3324 👎 0

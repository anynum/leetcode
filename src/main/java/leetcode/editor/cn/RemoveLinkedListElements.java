package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

/**
 * 题目：移除链表元素
 * 题目编号：203
 * 时间：2023-09-03 20:48:39
 * 通过：？
 */
public class RemoveLinkedListElements{
  public static void main(String[] args) {
       Solution solution = new RemoveLinkedListElements().new Solution();
       
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
    // 递归 通过
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        if (head != null){
            head.next = removeElements(head.next,val);
        }
        return head;
    }

    // 双指针  通过
    public ListNode removeElementsV2(ListNode head, int val) {
        while (head != null && head.val == val){
            head =head.next;
        }
        if (head == null){
            return head;
        }
        ListNode pre = head;
        ListNode post = head.next;
        while (post != null){
            if (post.val == val){
                // 移除post
                pre.next = post.next;
                post = post.next;
            }else {
                pre = post;
                post = post.next;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1325 👎 0

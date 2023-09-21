package leetcode.editor.cn;

import com.common.entity.ListNode;

/**
 * 题目：删除排序链表中的重复元素 II
 * 题目编号：82
 * 时间：2023-09-25 17:03:30
 * 通过：？
 */
public class RemoveDuplicatesFromSortedListIi{
  public static void main(String[] args) {
       Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
       
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode v = new ListNode(-101);
        v.next = head;
        ListNode tmp = head, pre = v;

        // 0,1,2,2,3,3,4,4,5
        while (tmp != null && tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                while (tmp.val == tmp.next.val) {
                    tmp = tmp.next;
                    if (tmp.next == null){
                        break;
                    }
                }
                pre.next = tmp.next;
                tmp = pre.next;
            } else {
                tmp = tmp.next;
                pre = pre.next;
            }
        }
        return v.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
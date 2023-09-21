package leetcode.editor.cn;

import com.common.entity.ListNode;

/**
 * 题目：删除排序链表中的重复元素
 * 题目编号：83
 * 时间：2023-09-25 17:03:05
 * 通过：true
 */
public class RemoveDuplicatesFromSortedList{
  public static void main(String[] args) {
       Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
       
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
        ListNode tmp = v;
        while (tmp.next != null){
            if (tmp.val == tmp.next.val){
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return v.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
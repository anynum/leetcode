package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

/**

/**
 * 题目：合并 K 个升序链表
 * 题目编号：23
 * 时间：2023-08-31 17:05:59
 * 通过：？
 */
public class MergeKSortedLists{
  public static void main(String[] args) {
       Solution solution = new MergeKSortedLists().new Solution();
      ListNode listNode3 = new ListNode(5);
      ListNode listNode2 = new ListNode(4,listNode3);
      ListNode listNode1 = new ListNode(1, listNode2);

      ListNode listNode6 = new ListNode(4);
      ListNode listNode5 = new ListNode(3,listNode6);
      ListNode listNode4 = new ListNode(1,listNode5);

      ListNode listNode8 = new ListNode(6);
      ListNode listNode7 = new ListNode(2,listNode8);

      ListNode[] lists = {listNode1, listNode4, listNode7};

      solution.mergeKLists(lists);
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();

        ListNode  p = head;

        while (true) {
            int index = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val <= min){
                    index = i;
                    min = lists[i].val;
                }
            }
            if (index == -1){
                break;
            }
            p.next = lists[index];
            p = p.next;
            lists[index] = lists[index].next;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2616 👎 0

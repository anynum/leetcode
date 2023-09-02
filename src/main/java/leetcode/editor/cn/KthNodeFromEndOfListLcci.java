package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

/**
 * /**
 * 题目：返回倒数第 k 个节点
 * 题目编号：面试题 02.02
 * 时间：2023-08-01 23:32:22
 * 通过：true
 */
public class KthNodeFromEndOfListLcci {
    public static void main(String[] args) {
        Solution solution = new KthNodeFromEndOfListLcci().new Solution();
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
        public int kthToLast(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
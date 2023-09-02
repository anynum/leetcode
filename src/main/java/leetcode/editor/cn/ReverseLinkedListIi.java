package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

import java.util.Stack;

/**
 * 题目：反转链表 II
 * 题目编号：92
 * 时间：2023-09-03 17:32:11
 * 通过：？
 */
public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            if (left == right || head == null || head.next == null) {
                return head;
            }

            // 不需要翻转的
            Stack<ListNode> stack1 = new Stack<>();
            // 待翻转的
            Stack<ListNode> stack2 = new Stack<>();

            ListNode tmp = head;
            ListNode pre = new ListNode();
            ListNode post = new ListNode();
            int len = 1;
            while (tmp != null) {
                if (len == left - 1) {
                    pre = tmp;
                }

                if (len == right + 1) {
                    post = tmp;
                }

                if (left <= len && len <= right) {
                    stack2.push(tmp);
                }
                tmp = tmp.next;
                len++;
            }

            if (left == 1) {
                // 从第一个开始翻转
                head = stack2.pop();
                tmp = head;
                while (!stack2.empty()) {
                    tmp.next = stack2.pop();
                    tmp = tmp.next;
                    // 防止链表循环,并且
                    // tmp.next = null;
                }

            } else {
                while (!stack2.empty()) {
                    pre.next = stack2.pop();
                    pre = pre.next;
                }
                pre.next = post;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1637 👎 0

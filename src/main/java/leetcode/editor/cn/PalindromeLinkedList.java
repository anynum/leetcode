package leetcode.editor.cn;

import com.common.entity.ListNode;
import leetcode.editor.cn.utils.LeetCodeUtils;

/**
 * /**
 * 题目：回文链表
 * 题目编号：234
 * 时间：2023-08-31 17:13:27
 * 通过：？
 *
 * 解答成功:
 * 	执行耗时:3 ms,击败了97.89% 的Java用户
 * 	内存消耗:57.7 MB,击败了51.28% 的Java用户
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        int[] nums = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
        ListNode head = LeetCodeUtils.array2ListNode(nums);
        boolean palindrome = solution.isPalindrome(head);
        System.out.println("palindrome = " + palindrome);

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
        public boolean isPalindrome(ListNode head) {
            // 快慢指针，快指针一次走两步，慢指针一次一步，当快指针走到末尾，慢指针刚好到链表中间，
            //
            // 翻转链表
            if (head == null || head.next == null) {
                return true;
            }

            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
//         int[] nums = {1, 2, 3, 4, 5, 4, 3, 2, 1};
            // 翻转后半部分
            ListNode tmp = slow;
            fast = slow;
            slow = slow.next;
            tmp.next = null;
            while (slow != null) {
                tmp = slow.next;
                slow.next = fast;
                fast = slow;
                slow = tmp;
            }

            // slow链表长度比fast多1，或者相等，fast = null时结束遍历
            slow = head;
            while (fast != slow && fast != null) {
                if (fast.val != head.val) {
                    return false;
                }
                fast = fast.next;
                head = head.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1765 👎 0

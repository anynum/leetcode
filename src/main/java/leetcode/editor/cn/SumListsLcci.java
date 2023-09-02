package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;
import leetcode.editor.cn.utils.LeetCodeUtils;

/**
 * /**
 * 题目：链表求和
 * 题目编号：面试题 02.05
 * 时间：2023-08-02 22:24:06
 */
public class SumListsLcci {
    public static void main(String[] args) {
        Solution solution = new SumListsLcci().new Solution();
        int[] nums1 = {2,4,3};
        int[] nums2 = {5,6,4};
        ListNode l1 = LeetCodeUtils.array2ListNode(nums1);
        ListNode l2 = LeetCodeUtils.array2ListNode(nums2);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1, p2 = l2;
            int t = 0;
            while (p1.next != null && p2.next != null){
                int m = (p1.val + p2.val + t) / 10;
                p1.val = (p1.val + p2.val + t) % 10;
                t = m;
                p1 = p1.next;
                p2 = p2.next;
            }

            if (t == 0){
                if (p1.next == null){
                    p1.next = p2.next;
                }
                return p1;
            } else {
                if (p1.next == null){
                    p1.next = p2.next;
                    while (p1.next == null || t == 0 ){
                        int m = (p1.next.val + t)/10;
                        p1.next.val = (p1.next.val + t) % 10;
                        t = m;
                        p1 = p1.next;
                    }
                } else {
                    while (p1.next == null || t != 0){
                        int m = (p1.next.val + t)/10;
                        p1.next.val = (p1.next.val + t) % 10;
                        t = m;
                        p1 = p1.next;
                    }
                }
                if (t == 1){
                    p1.next = new ListNode(1);
                }
            }

            return l1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
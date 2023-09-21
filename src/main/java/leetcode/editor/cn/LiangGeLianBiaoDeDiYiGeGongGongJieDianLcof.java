package leetcode.editor.cn;

import com.common.entity.ListNode;

/**
 * 题目：两个链表的第一个公共节点
 * 题目编号：剑指 Offer 52
 * 时间：2023-09-03 23:11:08
 * 通过：？
 */
public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    class Solution {
        ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenghtA = 0, lengthB = 0;
            ListNode a = headA, b = headB;
            while (a != null) {
                a = a.next;
                lenghtA++;
            }
            while (b != null) {
                b = b.next;
                lengthB++;
            }

            a = headA;
            b = headB;
            if (lenghtA >= lengthB) {
                int c = lenghtA - lengthB;
                while (c > 0) {
                    a = a.next;
                    c--;
                }
            } else {
                int c = lengthB - lenghtA;
                while (c > 0) {
                    b = b.next;
                    c--;
                }
            }
            while (a != b && a != null && b != null) {
                a = a.next;
                b = b.next;
            }
            return a;
        }


        ListNode getIntersectionNodeV1(ListNode headA, ListNode headB) {
            ListNode a = headA, b = headB;
            while (a != b) {
                a = a.next == null ? b : a.next;
                b = b.next == null ? a : b.next;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//输入两个链表，找出它们的第一个公共节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-
//lists/ 
// 
//
// Related Topics 哈希表 链表 双指针 👍 687 👎 0

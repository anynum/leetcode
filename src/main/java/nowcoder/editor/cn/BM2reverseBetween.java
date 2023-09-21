package nowcoder.editor.cn;
/**
 * nowcoder题目：链表内指定区间反转
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-14 22:02:50
 * nowcoder通过：？
 */

import com.common.entity.ListNode;
import leetcode.editor.cn.utils.LeetCodeUtils;
//nowcoder submit region begin(Prohibit modification and deletion)

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM2reverseBetween {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode v = new ListNode(-1);
        v.next = head;
        ListNode pre = null, post = null, left = null, right = null, tmp = v;
        for (int i = 0; i < n; i++) {
            if (i == m - 1) {
                pre = tmp;
            }
            tmp = tmp.next;
        }
        left = pre.next;
        right = tmp;
        post = tmp.next;

        right.next = null;
        reverseList(left);

        pre.next = right;
        left.next = post;
        return v.next;

    }

    private void reverseList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode tmp = head.next, p = null;
        head.next = null;
        while (tmp != null) {
            p = tmp.next;
            tmp.next = head;
            head = tmp;
            tmp = p;
        }
    }
//nowcoder submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNode = LeetCodeUtils.array2ListNode(nums);
        BM2reverseBetween solution = new BM2reverseBetween();
        solution.reverseBetween(listNode, 2,4);
    }

}

//将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 ，空间复杂度 。
// 例如：
// 给出的链表为 , ,
// 返回 .
// 
// 数据范围： 链表长度 ，，链表中每个节点的值满足 要求：时间复杂度 ，空间复杂度 进阶：时间复杂度 ，空间复杂度 
// Related Topics 链表 
//示例:
//输入:{1,2,3,4,5},2,4
//输出:{1,4,3,2,5}
//

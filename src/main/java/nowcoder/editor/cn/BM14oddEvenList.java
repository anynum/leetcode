package nowcoder.editor.cn;
/**
 * nowcoder题目：链表的奇偶重排
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 16:21:01
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

public class BM14oddEvenList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode j = head, o = head.next, cur = head.next.next;
        // write code here
        int index = 1;
        while (cur != null) {
            ListNode tmp = cur;
            if (index % 2 == 1){
                cur = cur.next;
                tmp.next = j.next;
                j.next = tmp;
                j = j.next;
                o.next = cur;
            } else {
                o = o.next;
                cur = cur.next;
            }
            index++;
        }
        return head;
    }
//nowcoder submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        ListNode listNode = LeetCodeUtils.array2ListNode(nums);
        BM14oddEvenList bm14oddEvenList = new BM14oddEvenList();
        bm14oddEvenList.oddEvenList(listNode);
    }

}

//给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。 注意是节点的编号而非节点的数值。 
// 数据范围：节点数量满足 ，节点中的值都满足 
// 要求：空间复杂度 ，时间复杂度 
// Related Topics 链表 排序 
//示例:
//输入:{1,2,3,4,5,6}
//输出:{1,3,5,2,4,6} 
//

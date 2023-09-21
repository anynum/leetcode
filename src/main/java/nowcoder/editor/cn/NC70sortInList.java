package nowcoder.editor.cn;
/**
 * nowcoder题目：单链表的排序
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 14:22:40
 * nowcoder通过：？
 */
import com.common.entity.ListNode;
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

public class NC70sortInList {
    public ListNode sortInList (ListNode head) {
        // write code here
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        list.sort((o1, o2) -> o1.val - o2.val);
        ListNode cur = new ListNode(-1);
        for (ListNode listNode : list) {
            cur.next = listNode;
            cur = cur.next;
        }
        cur.next = null;
        return list.get(0);
    }
//nowcoder submit region end(Prohibit modification and deletion)

}

//给定一个节点数为n的无序单链表，对其按升序排序。 数据范围：，保证节点权值在之内。 要求：空间复杂度 ，时间复杂度 
// Related Topics 链表 排序 
//示例:
//输入:[1,3,2,4,5]
//输出:{1,2,3,4,5}
//

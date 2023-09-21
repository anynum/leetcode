package nowcoder.editor.cn;
/**
 * nowcoder题目：单链表的排序
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-12 11:13:51
 * nowcoder通过：true
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

public class BM12sortInList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        while (head != null){
            queue.offer(head);
            head = head.next;

        }
        ListNode listNode = new ListNode(-1);
        ListNode tmp = listNode;
        while (!queue.isEmpty()){
            tmp.next = queue.poll();
            tmp = tmp.next;
        }
        tmp.next = null;
        return listNode.next;
    }
//nowcoder submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        int[] nums = {-426572,-406609,724427,-157789,-132713,720732,-39078,-348926,-693458,559374,114739,-748249,428207,-767407,401563,646432,-682870,483610,-608888,94840,749542,359115,131739,935294,347325,80573,-869091,-757897,-860166,-227942,-484068,-170790,-362441,-860466,819197,817675,886101,463504,-100482,496406,-860791};
        ListNode listNode = LeetCodeUtils.array2ListNode(nums);
        BM12sortInList solution = new BM12sortInList();
        ListNode listNode1 = solution.sortInList(listNode);
        LeetCodeUtils.printListNode(listNode1);
        System.out.println("listNode = " + listNode);

    }
}

//给定一个节点数为n的无序单链表，对其按升序排序。 数据范围：，保证节点权值在之内。 要求：空间复杂度 ，时间复杂度 
// Related Topics 链表 排序 
//示例:
//输入:[1,3,2,4,5]
//输出:{1,2,3,4,5}
//

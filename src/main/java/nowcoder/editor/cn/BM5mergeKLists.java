package nowcoder.editor.cn;
/**
 * nowcoder题目：合并k个已排序的链表
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-14 22:17:51
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)
import com.common.entity.ListNode;

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

public class BM5mergeKLists {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param lists ListNode类ArrayList 
     * @return ListNode类
     */
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        for (int i = 0; i < lists.size(); i++) {

        }
        // write code here
        return null;
    }

    private ListNode mergeTwoList(ListNode h1, ListNode h2){
        if (h1 == null){
            return h2;
        }
        if (h2 == null){
            return h1;
        }
        ListNode tmp = null;
        if (h1.val <= h2.val){
            tmp = h1.next;
            h1.next = h2;
            mergeTwoList(tmp, h2);
        }
        return  null;
    }

//nowcoder submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        // int[] nums = {};
        // ListNode listNode = LeetCodeUtils.array2ListNode(nums);
        BM5mergeKLists solution = new BM5mergeKLists();
    }

}

//合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。 
// 数据范围：节点总数 ，每个节点的val满足 要求：时间复杂度 
// Related Topics 堆 链表 分治 
//示例:
//输入:[{1,2,3},{4,5,6,7}]
//输出:{1,2,3,4,5,6,7}
//

package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;

/**
 * /**
 * 题目：移除重复节点
 * 题目编号：面试题 02.01
 * 时间：2023-08-01 22:55:57
 */
public class RemoveDuplicateNodeLcci {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
//        int[] list = {1, 2, 3, 3, 2, 1};
//        solution.removeDuplicateNodes(LeetCodeUtils.array2ListNode(list));


        String s = new String("销售账单统计.xls");
        byte[] b_gbk = s.getBytes("GBK");
        byte[] b_utf8 = s.getBytes("UTF-8");
        byte[] b_iso88591 = s.getBytes("ISO8859-1");


// 得到ISO8859-1编码字符
        String v1 = new String(s.getBytes("UTF-8"),"UTF-8");
        System.out.println("v1 = " + v1);

// 还原，得到正确的中文汉字"中"
        String v2 = new String(s.getBytes("GBK"),"GBK");
        System.out.println("v2 = " + v2);
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
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head != null){
                HashSet<Integer> set = new HashSet<>();
                set.add(head.val);
                ListNode p = head;
                ListNode tmp = p.next;
                while (tmp != null){
                    if (set.contains(tmp.val)){
                        p.next = tmp.next;
                        tmp = p.next;
                    } else {
                        set.add(tmp.val);
                        p = tmp;
                        tmp = tmp.next;
                    }
                }
            }
            return head;
        }

        public ListNode removeDuplicateNodes2(ListNode head) {
            ListNode p = new ListNode(-1, head);
            HashSet<Integer> set = new HashSet<>();
            ListNode tmp = head;
            while (tmp != null){
                if (set.contains(tmp.val)){
                    p.next = tmp.next;
                    tmp = p.next;
                } else {
                    set.add(tmp.val);
                    p = tmp;
                    tmp = tmp.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
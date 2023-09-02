package leetcode.editor.cn;


import leetcode.editor.cn.entity.ListNode;

public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = head, t = head;
            int len = 1;
            while (t.next != null) {
                len++;
                t = t.next;
            }
            // 首尾相连
            t.next = head;

            int m = len - (k % len) -1;
            for (int i = 0; i < m; i++) {
                p = p.next;
            }
            ListNode res = p.next;
            p.next = null;
            return res;
        }
    }


/**
 * 102 - 210 - 021 - 102 - 210
 */
//leetcode submit region end(Prohibit modification and deletion)

}
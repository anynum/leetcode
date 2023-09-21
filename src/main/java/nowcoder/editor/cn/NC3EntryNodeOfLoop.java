package nowcoder.editor.cn;

import com.common.entity.ListNode;

public class NC3EntryNodeOfLoop {
    public static void main(String[] args) {
        Solution solution = new NC3EntryNodeOfLoop().new Solution();

    }

//nowcoder submit region begin(Prohibit modification and deletion)

    public class Solution {
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            ListNode fast = pHead, slow = pHead;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    ListNode tmp = pHead;
                    while (slow != tmp) {
                        slow = slow.next;
                        tmp = tmp.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }
//nowcoder submit region end(Prohibit modification and deletion)

}


////给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。 // 数据范围： ， 要求：空间复杂度 ，时间复杂度 // 例如，输
//入{1,2},{3,4,5}时，对应的环形链表如下图所示： // 可以看到环的入口结点的结点值为3，所以返回结点值为3的结点。 // // Related 
//Topics 链表 哈希 双指针 //示例: //输入:{1,2},{3,4,5} //输出:3 //

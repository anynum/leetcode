package com.alibaba.coin.demo;

import leetcode.editor.cn.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author guopeng.Zgp 2022.04.13
 */
public class SegmentTest {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    /**
     * 以 132 为例的字典序
     * 1,
     * 10,
     * 100,101,102,103,104,105,106,107,108,109,
     * 11,110,111,112,113,114,115,116,117,118,119,
     * 12,120,121,122,123,124,125,126,127,128,129,
     * 13,130,131,132,
     * 14,15,16,17,18,19,
     * 2,20,21,22,23,24,25,26,27,28,29,
     * 3,30,31,32,33,34,35,36,37,38,39,
     * 4,40,41,42,43,44,45,46,47,48,49,
     * 5,50,51,52,53,54,55,56,57,58,59,
     * 6,60,61,62,63,64,65,66,67,68,69,
     * 7,70,71,72,73,74,75,76,77,78,79,
     * 8,80,81,82,83,84,85,86,87,88,89,
     * 9,90,91,92,93,94,95,96,97,98,99
     */
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0, j = 1; i < n; i++) {
            list.add(j);
            if (j * 10 > n) {
                j *= 10;
            } else {
                // 字典序，每行最多十个：0~9，当取模为9时说明已经遇到下一轮排序了，
                while (j % 10 == 9 || j + 1 > n) {
                    // 退回上一轮
                    j /= 10;
                }
                j++;
            }
        }
        return null;
    }

    /**
     * [2,4,3]
     * [5,6,4]
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = null;
        ListNode temp = null;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val; // 2
            int val2 = l2 == null ? 0 : l2.val; // 5
            int sum = val1 + val2 + flag;
            if (head == null) {
                head = new ListNode(sum % 10);
                temp = head;
            } else {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }
            flag = sum >= 10 ? 1 : 0;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (flag != 0) temp.next = new ListNode(flag);
        return head;
    }

    // 自己写的 ！！！
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head, left = head;
        for (int i = 0; i < n; i++) {
            right = right.next;

        }
        // 删除的是头结点的情况
        if (right == null) {
            return head.next;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        TreeMap<Integer, ListNode> treeMap = new TreeMap<>();
        if (lists.length == 0) return null;

        ListNode head = new ListNode(-100000);
        treeMap.put(-100000, head);
        for (int i = 0; i < lists.length; i++) {
            ListNode root = lists[i];
            while (root != null) {
                ListNode temp = new ListNode(); // 注意 这里用来存储root.next;
                Map.Entry<Integer, ListNode> entry = treeMap.floorEntry(root.val);
                temp = root.next;
                if (entry == null) {  // 插入头部
                    root.next = head.next;
                    head = root;
                } else {  // 插入指定位置
                    root.next = entry.getValue().next;
                    entry.getValue().next = root;
                }
                treeMap.put(root.val, root);
                root = temp;
            }
        }
        return head.next;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode guard = new ListNode(-1, head);
        ListNode fast = head, slow = guard;

        while (fast.next != null) {
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow.next.next = fast;

            if (fast.next != null) {
                slow = fast;
                fast = fast.next;
            }
        }
        return guard.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode guard = new ListNode(-101, head);
        ListNode tmp = guard;
        while (tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
                // 这里移除重复节点后，tmp指针不能后移，后续可能还有重复元素
            } else {
                tmp = tmp.next;
            }
        }
        return guard.next;
    }


    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] answer = new int[len];
        // 第一次，正向遍历
        for (int i = 0, j = -len; i < len; i++) {
            if (s.charAt(i) == c) {
                j = i;
            }
            // 初始化 j=-len, 当没有遇到C前，i-j >= len，在第二次遍历时方可被替换
            answer[i] = i - j;
        }
        // 第二次，反向遍历
        for (int i = len - 1, j = 2 * len; i >= 0; i--) {
            if (s.charAt(i) == c) {
                j = i;
            }
            // 初始化 j=2*len, 反向遍历在没有遇到C前，j-i >= len，避免原有值被替换
            answer[i] = Math.min(answer[i], j - i);
        }
        return answer;
    }


    // 超时？
    int[][] cache = new int[500][500];

    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int sum = Arrays.stream(piles).sum();
        int max = Math.max(getMaxXY(1, len - 1, piles) + piles[0], getMaxXY(0, len - 2, piles) + piles[len - 1]);
        return max > sum - max;
    }

    private int getMaxXY(int x, int y, int[] piles) {
        if (cache[x][y] != 0) {
            return cache[x][y];
        }
        if (y - x == 1) {
            int last = Math.max(piles[x], piles[y]);
            cache[x][y] = last;
            return last;
        }
        int max = Math.max(getMaxXY(x + 1, y, piles) + piles[x], getMaxXY(x, y - 1, piles) + piles[y]);
        cache[x][y] = max;
        return max;
    }

    public static String toGoatLatin(String sentence) {
        StringBuilder builder = new StringBuilder();

        int index = "o".indexOf(sentence);
        System.out.println("index = " + index);

        return null;
    }


}

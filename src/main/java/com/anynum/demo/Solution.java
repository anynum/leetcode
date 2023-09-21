package com.anynum.demo;

import com.common.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {

        String str = "aabcccccaaa";

        String first = "";
        String second = "m";

        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};


        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

//        int[] ints = reversePrint(listNode1);
//        System.out.println("");

        reverseList(listNode1);

        int[] ints = {2, 3, 1, 0, 2, 5, 3};
//        findRepeatNumber(ints);

        int[] nums = {-1,0,3,5,9,12};

        System.out.println(search2(nums, 9));


    }

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        int index = -1;
        int count = 0;
//        while (true){
//            mid = (left+right) >> 2;
//
//            if (target > nums[mid]){
//                left = mid;
//            }else if (target < nums[mid]){
//                right = mid;
//            } else {
//                index = mid;
//            }
//        }

//        int tem = index + 1;
//        while (tem < nums.length){
//            if (nums[tem] == nums[index]){
//                count++;
//                tem++;
//            }
//        }

        return 1;

    }

    // 二分查找
    public static int search2(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int letf=0,right=nums.length - 1;
        int mid = 0;
        while(letf <= right){
            mid = (letf + right) / 2;
            if(nums[mid] > target){
                right = mid-1;
            } else if(nums[mid] < target){
                letf = mid +1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    public static int findRepeatNumber(int[] nums) {
        // 以第一个位置为起始位置。
        int i = 0;
        int temp = 0;
        while (i < nums.length){
            // 当前位置的元素等与索引值，说明该元素本来就该放在这里
            if (nums[i] == i){
                i++;
                continue;
            }
            // 当前位置的元素和他本应该放置的位置的元素是否相等？相等说明重复
            if (nums[i] == nums[nums[i]]){
                return nums[i];
            }
            // 不相等则交换
            temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;

        }
        return -1;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode curr = head.next;
        ListNode temp = curr.next;
        head.next = null;
        curr.next = head;
        while (temp != null){
            head = curr;
            curr= temp;
            temp = curr.next;
            curr.next = head;
        }
        return curr;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = head.next;
        ListNode listNode = reverseList2(newHead.next);
        head.next =null;
        newHead.next = head;
        return newHead;
    }

    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        int[] ints = new int[stack.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack.pop();
        }

        return ints;
    }

    public static int[] reversePrintV2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int size = list.size();
        int[] ints = new int[size];

        for (int k = 0; k < list.size(); k++) {
            ints[k] = list.get(size - k - 1);
        }


        return ints;
    }


    // TODO 完成
    public static void rotate(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0, k = 0; i < length; i++, k++) {


        }

        for (int i = 1; i < length; i++) {
            for (int k = 0; k < length; k++) {

            }
        }
    }

    public static void rotateV2(int[][] matrix) {
        int n = matrix.length;

        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 再对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }


    public void setZeroes(int[][] matrix) {

        boolean[] line = new boolean[matrix.length];
        boolean[] row = new boolean[matrix[0].length];


        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++) {
                if (matrix[i][k] == 0) {
                    line[i] = true;
                    row[k] = true;
                }
            }
        }

        for (int i = 0; i < line.length; i++) {
            for (int k = 0; k < row.length; k++) {
                if (line[i] || row[k]) {
                    matrix[i][k] = 0;
                }
            }
        }
    }


    public static String compressString(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int l = 0;
        int r = 1;
        StringBuilder builder = new StringBuilder();
        while (r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                builder.append(s.charAt(l)).append(r - l);
                l = r;
            }
            r++;
        }
        builder.append(s.charAt(l)).append(r - l);
        return builder.length() < s.length() ? builder.toString() : s;

    }


    public static boolean oneEditAway(String first, String second) {

        int fl = first.length();
        int sl = second.length();

        if (fl < sl) {
            return oneEditAway(second, first);
        }

        if (fl - sl > 1) {
            return false;
        }

        if (fl == sl) {
            int count = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                }
            }
            return count <= 1;
        }


        int s = 0;
        int ofs = 0;
        while (s < sl) {
            if (second.charAt(s) != first.charAt(s + ofs)) {
                if (++ofs > 1) {
                    return false;
                }
            } else {
                s++;
            }
        }

        return true;
    }


    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count1 = count(s1);
        int[] count2 = count(s2);

        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] count(String s) {
        int[] ints = new int[128];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)]++;
        }
        return ints;
    }


    public boolean CheckPermutationV2(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return new String(array1).equals(new String(array2));
    }

    public static boolean isUnique(String str) {
        long num = 0L;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            // 减掉65，否则long长度不够
            long temp = 1L << (str.charAt(i) - 'A');
            // 1右移之后只有一位是1，其他位都是0，跟num做&运算后，其他位也都是0，如果相同位有冲突，则说明字符有重复
            if ((num & temp) != 0) {
                return false;
            } else {
                // 做或运算，标记当前位置有字符
                num |= temp;
            }
        }
        return true;
    }

    public static boolean isUniqueV2(String str) {
        int[] ints = new int[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (ints[c] == 1) {
                return false;
            }
            ints[c] = 1;
        }
        return true;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int multi = 1;
        for (int i = 0,j=1; j < nums.length;i++) {
            if (nums[i] < k){
                result++;
                while (multi*nums[j] < k){
                    result++;
                    multi *= nums[j];
                    j++;
                }
                multi /= nums[i++];
            }
        }
        return 0;
    }


}
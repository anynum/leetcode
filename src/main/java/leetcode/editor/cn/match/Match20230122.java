package leetcode.editor.cn.match;

import java.util.ArrayDeque;
import java.util.Deque;

public class Match20230122 {
    public static void main(String[] args) {

//        alternateDigitSum(521);

        int[][] score = {{10,6,9,1},{7,5,11,2},{4,8,3,15}};
        int[][] ints = sortTheStudents(score, 2);

    }

    public  static int alternateDigitSum(int n) {
        String value = String.valueOf(n);
        boolean flag = true;
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            String s = String.valueOf(value.charAt(i));
            if (flag){
                sum += Integer.parseInt(s);
            } else {
                sum -= Integer.parseInt(s);
            }
            flag = !flag;
        }
        return sum;
    }








    public static int[][] sortTheStudents(int[][] score, int k) {
        int length = score.length;
        int left = 0, right = length -1;

//        quickSortStackMedian3(score, k);
        quickSortMedian3(score,k, left, right);

        int[][] ans = new int[score.length][score[0].length];
        for (int i = score.length - 1, j=0; i >= 0; i--, j++) {
            ans[j] = score[i];
        }
        return ans;
    }




    // 单轴快排递归方法：三数取中
    private static void quickSortMedian3(int[][] arr, int k, int l, int r) {
        if (l < r) {
            median3(arr,k, l, r); // 执行median3将左，中，右三数中值放到left位置上
            int p = partition(arr, k, l, r);
            quickSortMedian3(arr, k, l, p - 1);
            quickSortMedian3(arr,k, p + 1, r);
        }
    }


    // 将left, center, right下标三个数中，大小居中者放到left下标处
    private static void median3(int[][] arr, int k, int l, int r) {
        int c = l + (r - l) / 2;
        if (arr[l][k] > arr[c][k]) swap(arr,k, l, c); // 左中，大者居中
        if (arr[c][k] > arr[r][k]) swap(arr,k, c, r); // 中右，大者居右，此时最大者居右
        if (arr[c][k] > arr[l][k]) swap(arr,k, l, c); // 左中，大者居左，此时中者居左
    }

    private static void swap(int[][] arr, int k, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // partition 方法
    private static int partition(int[][] arr, int k, int l, int r) {
        int j = l + 1;
        for (int i = j; i <= r; i++) {
            if (arr[i][k] < arr[l][k]) {
                swap(arr,k, i, j); // 交换后的 arr[j] 为当前最后一个小于主轴元素的元素
                j++;
            }
        }
        swap(arr,k, l, j - 1); // 主轴元素归位
        return j - 1;
    }


}

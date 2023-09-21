package com.anynum.demo.sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {2, 5, 8, 3, 1, 9, 6};
        quickSort.quickSortSimple(nums);

    }

    // 单轴快排：首位为轴
    public int[] quickSortSimple(int[] arr) {
        if (arr.length < 2) return arr;
        quickSortSimple(arr, 0, arr.length - 1);
        return arr;
    }

    // 单轴快排递归方法：首位为轴
    private void quickSortSimple(int[] arr, int l, int r) {
        if (l < r) { // 若left == right，表示此时 arr 只有一个元素，即为基准情形，完成递归
            int p = partition(arr, l, r);
            quickSortSimple(arr, l, p - 1);
            quickSortSimple(arr, p + 1, r);
        }
    }

    // partition 方法
    // 2,5,8,3,1,9,6  j=2
    // 3,5,8,2,1,9,6
    //
    private int partition(int[] arr, int l, int r) {
        int j = l + 1;
        for (int i = j; i <= r; i++) {
            if (arr[i] < arr[l]) {// arr[l]才是中轴
                swap(arr, i, j); // 交换后的 arr[j] 为当前最后一个小于主轴元素的元素
                j++;
            }
        }
        swap(arr, l, j - 1); // 主轴元素归位
        return j - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

// ------------------------------------------------------------------------------------------------------------

    // 单轴快排：三数取中
    public int[] quickSortMedian3(int[] arr) {
        if (arr.length < 2) return arr;
        quickSortMedian3(arr, 0, arr.length - 1);
        return arr;
    }

    // 单轴快排递归方法：三数取中
    private void quickSortMedian3(int[] arr, int l, int r) {
        if (l < r) {
            median3(arr, l, r); // 执行median3将左，中，右三数中值放到left位置上
            int p = partition(arr, l, r);
            quickSortMedian3(arr, l, p - 1);
            quickSortMedian3(arr, p + 1, r);
        }
    }


    // 将left, center, right下标三个数中，大小居中者放到left下标处
    private void median3(int[] arr, int l, int r) {
        int c = l + (r - l) / 2;
        if (arr[l] > arr[c]) swap(arr, l, c); // 左中，大者居中
        if (arr[c] > arr[r]) swap(arr, c, r); // 中右，大者居右，此时最大者居右
        if (arr[c] > arr[l]) swap(arr, l, c); // 左中，大者居左，此时中者居左
    }

// ------------------------------------------------------------------------------------------------------------

    // 单轴快排：随机轴
    public int[] quickSortRandom(int[] arr) {
        if (arr.length < 2) return arr;
        quickSortRandom(arr, 0, arr.length - 1);
        return arr;
    }

    // 单轴快排递归方法：随机轴
    private void quickSortRandom(int[] arr, int l, int r) {
        if (l < r) {
            int randIdx = new Random().nextInt(r - l) + l + 1; // 在 [left + 1, right] 范围内的随机值
            swap(arr, l, randIdx); // arr[l] 与它之后的某个数交换
            int p = partition(arr, l, r);
            quickSortRandom(arr, l, p - 1);
            quickSortRandom(arr, p + 1, r);
        }
    }

// ------------------------------------------------------------------------------------------------------------

    // 单轴快排迭代实现（利用栈）：首位为轴
    public int[] quickSortStackSimple(int[] arr) {
        if (arr.length < 2) return arr;
        Deque<Integer> stack = new ArrayDeque<>();  // 保存区间左右边界的栈，按right到left的顺序将初始区间界入栈
        stack.push(arr.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) { // 判断栈是否空，不空则弹出一对left，right界
            int l = stack.pop(), r = stack.pop();
            if (l < r) { // 执行partition的前提是 left 小于 right
                int p = partition(arr, l, r);
                stack.push(p - 1);
                stack.push(l);
                stack.push(r);
                stack.push(p + 1);
            }
        }
        return arr;
    }

// ------------------------------------------------------------------------------------------------------------

    // 单轴快排迭代实现（利用栈）：三数取中
    public int[] quickSortStackMedian3(int[] arr) {
        if (arr.length < 2) return arr;
        Deque<Integer> stack = new ArrayDeque<>();  // 保存区间左右边界的栈，按right到left的顺序将初始区间界入栈
        stack.push(arr.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) { // 判断栈是否空，不空则弹出一对left，right界
            int l = stack.pop(), r = stack.pop();
            if (l < r) { // 执行partition的前提是 left 小于 right
                median3(arr, l, r);
                int p = partition(arr, l, r);
                stack.push(p - 1);
                stack.push(l);
                stack.push(r);
                stack.push(p + 1);
            }
        }
        return arr;
    }

// ------------------------------------------------------------------------------------------------------------

    // 单轴快排迭代实现（利用栈）：随机轴
    public int[] quickSortStackRandom(int[] arr) {
        if (arr.length < 2) return arr;
        Deque<Integer> stack = new ArrayDeque<>();  // 保存区间左右边界的栈，按right到left的顺序将初始区间界入栈
        stack.push(arr.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) { // 判断栈是否空，不空则弹出一对left，right界
            int l = stack.pop(), r = stack.pop();
            if (l < r) { // 执行partition的前提是 left 小于 right
                int randIdx = new Random().nextInt(r - l + 1) + l;
                swap(arr, l, randIdx);
                int p = partition(arr, l, r);
                stack.push(p - 1);
                stack.push(l);
                stack.push(r);
                stack.push(p + 1);
            }
        }
        return arr;
    }

// ------------------------------------------------------------------------------------------------------------

    public int[] dualPivotQuickSort(int[] arr) {
        if (arr.length < 2) return arr;
        dualPivotQuickSort(arr, 0, arr.length - 1); // 后两个参数是下标值
        return arr;
    }

    /*
     *     区间1               区间2                         区间3
     * +------------------------------------------------------------+
     * |  < pivot1  | pivot1 <= && <= pivot2  |    ?    | > pivot2  |
     * +------------------------------------------------------------+
     *              ^                         ^         ^
     *              |                         |         |
     *            lower                     index      upper
     */
    private void dualPivotQuickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 令左右两端元素中较小者居左，以left为初始pivot1，right为初始pivot2
            // 即arr[left]为选定的左轴值，arr[right]为选定的右轴值
            if (arr[left] > arr[right]) {
                swap(arr, left, right);
            }
            int index = left + 1; // 当前考察元素下标
            int lower = left + 1; // 用于推进到pivot1最终位置的动态下标，总有[left, lower)确定在区间1中
            int upper = right - 1; // 用于推进到pivot2最终位置的动态下标，总有(upper, right]确定在区间3中
            // [lower, index)确定在区间2中，[index, upper]为待考察区间。

            // upper以右（不含upper）的元素都是确定在区间3的元素，所以考察元素的右界是upper
            while (index <= upper) {
                // 若arr[index] < arr[left]，即arr[index]小于左轴值，则arr[index]位于区间1
                if (arr[index] < arr[left]) {
                    // 交换arr[index]和arr[lower]，配合后一条lower++，保证arr[index]位于区间1
                    swap(arr, index, lower);
                    // lower++，扩展区间1，lower位置向右一位靠近pivot1的最终位置
                    lower++;
                }
                // 若arr[index] > arr[right]，即arr[index]大于右轴值，则arr[index]位于区间3
                else if (arr[index] > arr[right]) {
                    // 先扩展区间3，使得如下while结束后upper以右（不含upper）的元素都位于区间3
                    // 区间3左扩不可使index == upper，否则之后的第二条upper--将导致upper为一个已经确定了区间归属的元素的位置（即index - 1）
                    while (arr[upper] > arr[right] && index < upper) {
                        upper--;
                    }
                    // 交换arr[index]和arr[upper]，配合后一条upper--，保证arr[index]位于区间3
                    swap(arr, index, upper);
                    upper--;
                    // 上述交换后，index上的数字已经改变，只知道此时arr[index] ≤ arr[right]，arr[index]有可能在区间1或区间2，
                    // 若arr[index] < arr[left]，即arr[index]小于左轴值，则arr[index]位于区间1
                    if (arr[index] < arr[left]) {
                        // 交换arr[index]和arr[lower]，配合后一条lower++，保证arr[index]位于区间1
                        swap(arr, index, lower);
                        // lower++，扩展区间1，lower位置向右一位靠近pivot1的最终位置
                        lower++;
                    }
                }
                index++; // 考察下一个数字
            }
            // while(index <= upper)结束后最后一个确定在区间1的元素的下标是lower--，
            // 最后一个确定在区间3的元素下标是upper++。
            lower--;
            upper++;
            // 双轴归位。此时的lower，upper即分别为最终pivot1(初始时为left)，最终pivot2(初始时为right)。
            swap(arr, left, lower);
            swap(arr, upper, right);
            // 对三个子区间分别执行双轴快排
            dualPivotQuickSort(arr, left, lower - 1); // 区间1
            dualPivotQuickSort(arr, lower + 1, upper - 1); // 区间2
            dualPivotQuickSort(arr, upper + 1, right); // 区间3
        }
    }

// ------------------------------------------------------------------------------------------------------------

    // 默认将pivot放在第一位
    private int partition2(int[] nums, int l, int r) {
        int j = l + 1; // 从pivot后一位开始比较
        // j应该指向的是第一个大于pivot的值
        for (int i = j; i < r; i++) {
            if (nums[i] < nums[l]) {
                if (i != j) {
                    swap(nums, i, j);
                }
                j++;
            }
        }
        swap(nums, l, j - 1);
        return j - 1;
    }

}

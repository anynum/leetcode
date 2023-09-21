package com.anynum.demo.sort;

public class MergeSort {
    public static void main(String[] args) {
        // 调用
        int[] nums = {3, 4, 1, 5, 2, 1};
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int l, int r) {
        // 终止条件
        if (l >= r) return;
        // 递归划分
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);

        // 合并子数组
        mergeArray(nums, l, r, m);
    }

    // 1,5,7,9, 2,4,6,8,10
    private static void mergeArray(int[] nums, int l, int r, int m) {
        int[] tmp = new int[r - l + 1]; // 暂存需合并区间[l, r]元素
        for (int k = l; k <= r; k++)
            tmp[k - l] = nums[k];

        int i = 0, j = m - l + 1;// 两指针分别指向左/右子数组的首个元素
        for (int k = l; k <= r; k++) {  // 遍历合并左/右子数组
            if (i == m - l + 1)
                nums[k] = tmp[j++];
            else if (j == r - l + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
            }
        }
    }


// --------------------- 自顶向下非原地归并 start------------------------------------------------------------------------

    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;

        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
        return arr;
    }

    // mergeSort 递归方法
    private void mergeSort(int[] arr, int[] tmpArr, int l, int r) {
        if (l < r) {
            int c = l + (r - l) / 2;

            mergeSort(arr, tmpArr, l, c);
            mergeSort(arr, tmpArr, c + 1, r);

            merge(arr, tmpArr, l, c, r);
        }
    }

    // 非原地合并方法
    private void merge(int[] arr, int[] tmpArr, int l, int c, int r) {
        int lh = l, rh = c + 1, h = l; // lh: left head, rh: right head, h: tmpArr head

        while (lh <= c && rh <= r) {
            tmpArr[h++] = arr[lh] <= arr[rh] ? arr[lh++] : arr[rh++];
        }
        while (lh <= c) tmpArr[h++] = arr[lh++]; // 左半边还有剩余，加入 tmpArr 末尾
        while (rh <= r) tmpArr[h++] = arr[rh++]; // 右半边还有剩余，加入 tmpArr 末尾

        for (; l <= r; l++) arr[l] = tmpArr[l]; // 将 tmpArr 拷回 arr 中
    }

// --------------------- 自顶向下非原地归并 end--------------------------------------------------------------------------


// --------------------- 自顶向下原地归并 start--------------------------------------------------------------------------

    public int[] mergeSortV2(int[] arr) {
        if (arr.length < 2) return arr;
        mergeSortV2(arr, 0, arr.length - 1);
        return arr;
    }

    // mergeSort 递归方法
    private void mergeSortV2(int[] arr, int l, int r) {
        if (l < r) {
            int c = l + (r - l) / 2;
            mergeSort(arr, l, c);
            mergeSort(arr, c + 1, r);
            merge(arr, l, c, r);
        }
    }

    // 原地归并（手摇算法）
    private void merge(int[] arr, int l, int c, int r) {
        int i = l, j = c + 1; // #1
        while (i < j && j <= r) {
            while (i < j && arr[i] <= arr[j]) i++; // #2
            int index = j; // #3
            while (j <= r && arr[j] < arr[i]) j++; // #4 注意是 arr[j] < arr[i]，即找到j使得arr[j] 为第一个大于等于 arr[i]值
            exchange(arr, i, index - 1, j - 1); // #5
        }
    }

    // 三次翻转实现交换
    private void exchange(int[] arr, int l, int c, int r) {
        reverse(arr, l, c);
        reverse(arr, c + 1, r);
        reverse(arr, l, r);
    }

    // 原地翻转
    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l++, r--);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

// --------------------- 自顶向下原地归并 end ---------------------------------------------------------------------------


// --------------------- 自底向上非原地归并 start ------------------------------------------------------------------------

    public int[] mergeSortBU(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length;
        int[] tmpArr = new int[n];
        for (int gap = 1; gap < n; gap *= 2) { // 基本分区合并(随着间隔的成倍增长，一一合并，二二合并，四四合并...)
            for (int l = 0; l < n - gap; l += 2 * gap) { // leftEnd = left+gap-1; rightEnd = left+2*gap-1;
                int r = Math.min(l + 2 * gap - 1, n - 1); // 防止最后一次合并越界
                merge(arr, tmpArr, l, l + gap - 1, r);
            }
        }
        return arr;
    }


// --------------------- 自底向上非原地归并 end ------------------------------------------------------------------------------


// --------------------- 自底向上原地 start ------------------------------------------------------------------------------

    // 归并排序四：
    public int[] mergeSortBUInPlace(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length;
        for (int gap = 1; gap < n; gap *= 2) {
            for (int l = 0; l < n - gap; l += 2 * gap) { // 基本分区合并(随着间隔的成倍增长，一一合并，二二合并，四四合并...)
                int r = Math.min(l + 2 * gap - 1, n - 1); // leftEnd = left+gap-1; rightEnd = left+2*gap-1;
                merge(arr, l, l + gap - 1, r);
            }
        }
        return arr;
    }

// --------------------- 自顶向下原地归并 end ------------------------------------------------------------------------------
}

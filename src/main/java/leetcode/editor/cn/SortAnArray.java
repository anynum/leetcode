package leetcode.editor.cn;

import java.util.Random;

/**
 * 题目：排序数组
 * 题目编号：912
 * 时间：2023-09-26 15:44:03
 * 通过：？
 */
public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random random = new Random();

        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int l, int r) {
            if (l >= r) {
                return;
            }
            int p = (r - l) / 2 + l;
            // 将中轴元素放到数组首位
            swap(nums, l, p);
            int pivotIndex = partition(nums, l, r);
            // 左区间
            quickSort(nums, l, pivotIndex - 1);
            // 右区间, 开始之前，跳过和pivot相等的值
            while (pivotIndex < r - 1) {
                if (nums[pivotIndex] == nums[pivotIndex + 1]) {
                    pivotIndex++;
                } else {
                    break;
                }
            }
            quickSort(nums, pivotIndex + 1, r);
        }

        // 默认中轴数组首位
        private int partition(int[] nums, int l, int r) {
            int j = l + 1;
            for (int i = j; i <= r; i++) {
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

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
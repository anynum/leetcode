package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

/**
 * 题目：合并两个有序数组
 * 题目编号：88
 * 时间：2023-10-11 17:58:14
 * 通过：？
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {1};
        int[] nums2 = {};
        solution.merge(nums1, 1, nums2, 0);
        System.out.println("nums1 = " + JSON.toJSONString(nums1));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            /**
             * nums1从后往前填充
             * 1.nums2填完后，结束
             * 2，nums1填完后，吧nums2剩余的全填入nums1
             */
            int l = m - 1, r = n - 1, cur = m+n-1;
            while (cur >= 0) {
                if (r < 0) break;
                if (l < 0) {
                    for (int i = r; i >= 0; i--) {
                        nums1[cur--] = nums2[i];
                    }
                    break;
                }
                if (nums1[l] >= nums2[r]) {
                    nums1[cur--] = nums1[l--];
                } else {
                    nums1[cur--] = nums2[r--];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
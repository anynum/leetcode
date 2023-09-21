package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目：摆动排序 II
 * 题目编号：324
 * 时间：2023-09-27 14:48:53
 * 通过：true
 */
public class WiggleSortIi {
    public static void main(String[] args) {
        Solution solution = new WiggleSortIi().new Solution();
         int[] nums1 = {1,5,1,1,6,4 };
        // int[] nums2 = { };
        solution.wiggleSort(nums1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            int[] help = nums.clone();
            Arrays.sort(help);
            int N = nums.length;
            // 第一次遍历，现将最大的一批数插入到偶数位
            for (int i = 1; i < help.length; i += 2) {
                nums[i] = help[--N]; //遍历完成后 x 6 x 5 x 4
            }
            // 第二次遍历，将剩余的数依次插入到奇数位；
            for (int i = 0; i < help.length; i += 2) {
                nums[i] = help[--N]; //便利完成后 3 6 2 5 1 4
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
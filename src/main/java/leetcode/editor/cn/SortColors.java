package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

/**
 * 题目：颜色分类
 * 题目编号：75
 * 时间：2023-10-10 11:54:08
 * 通过：？
 */
public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] nums1 = {0, 1, 2};
//        int[] nums1 = {1,0,2};
        // int[] nums2 = { };
        solution.sortColors(nums1);
        System.out.println(JSON.toJSONString(nums1));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int len = nums.length;
            int l = -1, r = len, cur = 0;
            /**
             * 交换的关键点在于：
             * 1.把2交换到后面，换到前面的数还要再进行比较，所以交换后cur不能后移
             * 2.cur从索引0开始，如果遇到2，一定被换到后边去了，交换到前面的一定是0或者1，所以交换后cur需要后移
             * 3.遇到1不用管，后边遇到0会自动换到后边
             */
            while (cur < r) {
                if (nums[cur] == 0) {
                    if (cur != l + 1) swap(nums, l + 1, cur);
                    l++;
                    cur++;
                } else if (nums[cur] == 2) {
                    if (cur != r - 1) swap(nums, r - 1, cur);
                    r--;
                } else {
                    cur++;
                }
            }
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
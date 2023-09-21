package leetcode.editor.cn;

/**
 * 题目：删除有序数组中的重复项 II
 * 题目编号：80
 * 时间：2023-10-10 17:22:06
 * 通过：？
 */
public class RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
        int[] nums1 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        // int[] nums2 = { };
        int i = solution.removeDuplicates(nums1);
        System.out.println("i = " + i);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 2) {
                return nums.length;
            }
            int l = 0, r = 1, pre = nums[0], count = 1;
            while (r < nums.length) {
                /**
                 * 当前数字和上一个数字一样相等？
                 *  是：计数是否大于2
                 *      否：把当前数字移动到l后一个位置，l后移，r后移
                 *      是：l不动，r后移
                 *  否：
                 *      1.更新pre
                 *      2.重置计数
                 *      3.把当前数字移动到l后一个位置，l后移，r后移
                 */
                if (nums[r] == pre) {
                    count++;
                    if (count <= 2) {
                        nums[++l] = nums[r];
                    }
                } else {
                    pre = nums[r];
                    count = 1;
                    nums[++l] = nums[r];
                }
                r++;
            }
            // l的位置即为最后一个数字的位置
            return l + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
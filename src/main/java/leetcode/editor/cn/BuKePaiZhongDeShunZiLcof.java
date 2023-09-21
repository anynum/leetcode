package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目：扑克牌中的顺子
 * 题目编号：剑指 Offer 61
 * 时间：2023-09-01 16:39:02
 * 通过：true
 */
public class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        int[] nums = {0, 0, 8, 5, 4};
        boolean straight = solution.isStraight(nums);
        System.out.println("straight = " + straight);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int pokers = 0, c = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == 0) {
                    pokers++;
                    continue;
                }
                if (i > 0) {
                    if (nums[i - 1] == 0) {
                        continue;
                    }
                    if (nums[i] == nums[i - 1]) {
                        return false;
                    }
                    c += nums[i] - nums[i - 1] - 1;
                }
            }
            return pokers >= c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
//
// Related Topics 数组 排序 👍 358 👎 0

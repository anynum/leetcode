package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 题目：第三大的数
 * 题目编号：414
 * 时间：2023-09-03 20:55:13
 * 通过：？
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Integer thirdMax(int[] nums) {


            TreeSet<Integer> set = new TreeSet<>();
            for (int num : nums) set.add(num);

            if (set.size() < 3) return set.last();

            Iterator<Integer> iterator = set.descendingIterator();
            Integer temp = null;
            for (int i = 0; i < 3; i++) {
                if (iterator.hasNext()) temp = iterator.next();
            }

            return temp;

        }

        public Integer thirdMaxV2(int[] nums) {


            int[] ints = Arrays.stream(nums).sorted().toArray();

            if (ints.length < 3) return ints[nums.length - 1];

            int second = 0;
            boolean flag = true;

            for (int i = ints.length - 1; i >= 0; i--) {
                if (ints[i] != ints[i - 1] && flag) {
                    second = ints[i];
                    flag = false;
                }
                if (ints[i] != ints[ints.length - 1] && ints[i] != second) {
                    return ints[i];
                }
            }

            return ints[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
//
// Related Topics 数组 排序 👍 435 👎 0

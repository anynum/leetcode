package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 题目：存在重复元素
 * 题目编号：217
 * 时间：2023-09-03 17:36:54
 * 通过：true
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            // hash表
//        执行用时：4 ms, 在所有 Java 提交中击败了79.98%的用户
//        内存消耗：42 MB, 在所有 Java 提交中击败了66.95%的用户
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.add(num)) {
                    return false;
                }
            }
            return true;
        }

        public boolean containsDuplicateV2(int[] nums) {
            // 执行用时：7 ms, 在所有 Java 提交中击败了34.77%的用户
            // 内存消耗：45 MB, 在所有 Java 提交中击败了12.72%的用户
            return Arrays.stream(nums).distinct().count() != nums.length;
        }

        public boolean containsDuplicateV3(int[] nums) {
            // 执行用时：4 ms, 在所有 Java 提交中击败了79.98%的用户
            // 内存消耗：42 MB, 在所有 Java 提交中击败了66.95%的用户
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,3,3,4,3,2,4,2]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 排序 👍 1043 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目：检查整数及其两倍数是否存在
 * 题目编号：1346
 * 时间：2023-09-03 22:37:15
 * 通过：？
 */
public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        Solution solution = new CheckIfNAndItsDoubleExist().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfExist(int[] arr) {
            int[] ints = Arrays.stream(arr).sorted().toArray();
            int max = ints[ints.length - 1];
            int min = ints[0];
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] << 1 > max || ints[i] << 1 < min) {
                    continue;
                }
                if (ints[i] > 0) {
                    for (int k = i + 1; k < ints.length; k++) {
                        if (ints[i] << 1 == ints[k]) return true;
                    }
                } else {
                    for (int j = i - 1; j >= 0; j--) {
                        if (ints[i] << 1 == ints[j]) return true;
                    }
                }
            }
            return false;
        }

        public boolean checkIfExist2(int[] arr) {
            int[] ints = Arrays.stream(arr).sorted().toArray();
            int max = ints[ints.length - 1];
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] * 2 > max) {
                    return false;
                }
                for (int j = i + 1; j < ints.length; j++) {
                    if (ints[i] * 2 == ints[j]) {
                        return true;
                    }
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。 
//
// 更正式地，检查是否存在两个下标 i 和 j 满足： 
//
// 
// i != j 
// 0 <= i, j < arr.length 
// arr[i] == 2 * arr[j] 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
// 
//
// 示例 3： 
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 500 
// -10^3 <= arr[i] <= 10^3 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 101 👎 0

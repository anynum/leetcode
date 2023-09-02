package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Collections;

/**
 * /**
 * 题目：交换和
 * 题目编号：面试题 16.21
 * 时间：2023-08-04 11:31:44
 * 通过：true
 */
public class SumSwapLcci {
    public static void main(String[] args) {
        Solution solution = new SumSwapLcci().new Solution();
        int[] a1 = {519, 886, 282, 382, 662, 4718, 258, 719, 494, 795};
        int[] a2 = {52, 20, 78, 50, 38, 96, 81, 20};


        int[] swapValues = solution.findSwapValues(a1, a2);
        System.out.println("swapValues = " + JSON.toJSONString(swapValues));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int c = Arrays.stream(array1).sum() - Arrays.stream(array2).sum();
        if (c % 2 != 0) {
            return new int[]{};
        }
        Arrays.sort(array2);
        for (int i : array1) {
            int b = binarySearch(array2, i - c / 2);
            if (b != -1) {
                return new int[]{i, b};
            }
        }
        return new int[]{};
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。 
//
// 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
// 
//
// 示例: 
//
// 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
//输出: [1, 3]
// 
//
// 示例: 
//
// 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
//输出: [] 
//
// 提示： 
//
// 
// 1 <= array1.length, array2.length <= 100000 
// 
//
// Related Topics 数组 哈希表 二分查找 排序 👍 47 👎 0

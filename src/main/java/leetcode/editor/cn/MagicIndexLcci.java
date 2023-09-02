package leetcode.editor.cn;

/**
 * /**
 * 题目：魔术索引
 * 题目编号：面试题 08.03
 * 时间：2023-08-04 11:31:18
 * 通过：True
 */
public class MagicIndexLcci {
    public static void main(String[] args) {
        Solution solution = new MagicIndexLcci().new Solution();

    }

    class Solution {
        public int findMagicIndex(int[] nums) {
            int l = 0, r = nums.length - 1;
            return findMagicIndexPost(nums, l, r);
        }

        private int findMagicIndexPost(int[] nums, int l, int r) {
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == mid) {
                    // 向前
                    int p = findMagicIndexPost(nums, l, mid - 1);
                    if (p != -1) {
                        return Math.min(p, mid);
                    }
                    return mid;
                } else {
                    // 向前
                    int p1 = findMagicIndexPost(nums, l, mid - 1);
                    // 向后
                    if (p1 != -1) {
                        return p1;
                    }
                    return findMagicIndexPost(nums, mid + 1, r);
                }
            }
            return -1;
        }
    }

}


//魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找
//出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。 
//
// 示例1: 
//
//  输入：nums = [0, 2, 3, 4, 5]
// 输出：0
// 说明: 0下标的元素为0
// 
//
// 示例2: 
//
//  输入：nums = [1, 1, 1]
// 输出：1
// 
//
// 说明: 
//
// 
// nums长度在[1, 1000000]之间 
// 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本 
// 
//
// Related Topics 数组 二分查找 👍 128 👎 0

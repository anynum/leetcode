package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 题目：数组中的第K个最大元素
 * 题目编号：215
 * 时间：2023-09-19 09:32:23
 * 通过：？
 */
public class KthLargestElementInAnArray{
  public static void main(String[] args) {
       Solution solution = new KthLargestElementInAnArray().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k){
            return -1;
        }
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        return quickSelect(numsList, k);
    }

    private int quickSelect(List<Integer> nums, int k){
        Integer pivot = nums.get(random.nextInt(nums.size()));
        List<Integer> small = new ArrayList<>();
//        List<Integer> equal = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        for (Integer num : nums) {
            if (num < pivot){
                small.add(num);
            }else if (num > pivot){
                big.add(num);
            } else {
//                equal.add(pivot);
            }
        }

        if (k <= big.size()){
            return quickSelect(big, k);
        }
        // k -
        if (k > nums.size() - small.size()){
            return quickSelect(small, k - nums.size() + small.size());
        }
        return pivot;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2293 👎 0

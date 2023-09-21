package nowcoder.editor.cn;
/**
 * nowcoder题目：接雨水问题
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-08 10:31:54
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)
import java.util.*;


public class BM94maxWater {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater (int[] arr) {
        if (arr.length <= 1){
            return 0;
        }
        int[] left = new int[arr.length];
//        int[] right = new int[arr.length];
        left[0] = arr[0];
//        right[arr.length-1] = arr[arr.length-1];
        int rMax = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }
        int res = 0;
        for (int i = arr.length - 2; i >= 0; i--) {

            // 提前计算, O(n)的时间和空间复杂度
//            if (arr[i+1] < left[i+1] && arr[i+1] < right[i+1]){
            if (arr[i+1] < left[i+1] && arr[i+1] < rMax){
//                res += Math.min(left[i+1],right[i+1]) - arr[i+1];
                res += Math.min(left[i+1], rMax ) - arr[i+1];
            }

//            right[i] = Math.max(right[i+1], arr[i]);
            rMax = Math.max(rMax, arr[i]);
        }

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < left[i] && arr[i]< right[i]){
//                res += Math.min(left[i],right[i]) - arr[i];
//            }
//        }
        return res;
        // write code here
    }
//nowcoder submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        int[] nums = {3,1,2,5,2,4};
        BM94maxWater water = new BM94maxWater();
        water.maxWater(nums);
    }

}

//给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个柱子高度图，计算按此排列的柱子，下雨之后能接多少雨水。(数组以外的区域高度视为0) 
// 
// 数据范围：数组长度 ，数组中每个值满足 ，保证返回结果满足 要求：时间复杂度 
// Related Topics 双指针 单调栈 动态规划 
//示例:
//输入:[3,1,2,5,2,4] 
//输出:5 
//

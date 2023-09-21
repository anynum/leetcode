package nowcoder.editor.cn;
/**
 * nowcoder题目：盛水最多的容器
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-08 17:30:32
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)
import java.util.*;


public class BM93maxArea {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param height int整型一维数组 
     * @return int整型
     */
    public int maxArea (int[] height) {
        if (height.length < 2){
            return 0;
        }
        int left = 0, right = height.length-1;
        int max = 0;
        while (left < right){
            max = Math.max(max, Math.min(height[left] , height[right]) * (right - left));
            int tmp = 0;
            if (height[left] <= height[right]){
                tmp = height[left];
                while (left <right && height[++left] <= tmp);
            } else {
                tmp = height[right];
                while (left < right && height[--right] <= tmp);
            }
        }
        return max;
    }
//nowcoder submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        BM93maxArea solution = new BM93maxArea();
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int i = solution.maxArea(nums);
        System.out.println("i = " + i);
    }

}

//给定一个数组height，长度为n，每个数代表坐标轴中的一个点的高度，height[i]是在第i点的高度，请问，从中选2个高度与x轴组成的容器最多能容纳多少
//水 1.你不能倾斜容器 2.当n小于2时，视为不能形成容器，请返回0 3.数据保证能容纳最多的水不会超过整形范围，即不会超过2³¹-1 
// 数据范围: 
// 
// 如输入的height为[1,7,3,2,4,5,8,2,7]，那么如下图: 
// 
// 
// Related Topics 双指针 数组 
//示例:
//输入:[1,7,3,2,4,5,8,2,7]
//输出:49 
//

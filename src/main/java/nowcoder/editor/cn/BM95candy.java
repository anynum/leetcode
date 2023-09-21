package nowcoder.editor.cn;
/**
 * nowcoder题目：分糖果问题
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 17:51:32
 * nowcoder通过：？
 */

import com.sun.tools.corba.se.idl.constExpr.And;
//nowcoder submit region begin(Prohibit modification and deletion)


import java.util.*;


public class BM95candy {

    public int candy(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                ans[i] = Math.max(ans[i], ans[i + 1] + 1);
            }
        }
        return Arrays.stream(ans).sum();
    }

//nowcoder submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        BM95candy candy = new BM95candy();
//        int[] nums = {10, 4, 10, 10, 4};
        int[] nums = {4,4, 4};
        int candy1 = candy.candy(nums);
        System.out.println("candy1 = " + candy1);
    }

}

//一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下： 
// 1. 每个孩子不管得分多少，起码分到一个糖果。
// 2. 任意两个相邻的孩子之间，得分较多的孩子必须拿多一些糖果。(若相同则无此限制)
// 
// 给定一个数组 代表得分数组，请返回最少需要多少糖果。 
// 要求: 时间复杂度为 空间复杂度为 
// 数据范围： ， 
// 
// Related Topics 贪心 
//示例:
//输入:[3,1,0,2,3, 4, 3,2]
//输出:4
//

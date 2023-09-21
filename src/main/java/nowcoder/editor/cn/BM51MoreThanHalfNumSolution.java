package nowcoder.editor.cn;
/**
 * nowcoder题目：数组中出现次数超过一半的数字
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-08 16:01:08
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)

import java.util.*;


public class BM51MoreThanHalfNumSolution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int MoreThanHalfNum_BM51MoreThanHalfNumSolution(int[] numbers) {
        if (numbers.length == 1){
            return numbers[0];
        }
        int count = 0, ans = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (ans == -1) {
                ans = numbers[i];
                count++;
                continue;
            }
            if (ans != numbers[i]) {
                if (--count == 0) {
                    ans = -1;
                }
            } else {
                count++;
            }
        }
        return ans;
        // write code here
    }
//nowcoder submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        BM51MoreThanHalfNumSolution solution = new BM51MoreThanHalfNumSolution();
        int[] nums = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        solution.MoreThanHalfNum_BM51MoreThanHalfNumSolution(nums);
    }

}

//给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
//由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。 
// 数据范围：，数组中元素的值 要求：空间复杂度：，时间复杂度 
// Related Topics 哈希 数组 
//示例:
//输入:[1,2,3,2,2,2,5,4,2]
//输出:2
//

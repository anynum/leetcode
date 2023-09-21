package nowcoder.editor.cn;
/**
 * nowcoder题目：三数之和
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 15:28:19
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)

import java.util.*;


public class BM54threeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                break;
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int left = i + 1, right = num.length - 1;
            while (left < right){
                int sum = num[i] + num[left] + num[right];
                if (sum == 0) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(num[i]);
                    tmp.add(num[left]);
                    tmp.add(num[right]);
                    list.add(tmp);
                    // 只有一边移动不行
                    while (left < right && num[right] == num[--right]) ;
                    while (left < right && num[left] == num[++left]) ;
                } else if (sum > 0) {
                    while (left < right && num[right] == num[--right]) ;
                } else {
                    while (left < right && num[left] == num[++left]) ;
                }
            }

        }
        return list;
        // write code here
    }

//nowcoder submit region end(Prohibit modification and deletion)

}

//给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。 
// 数据范围：，数组中各个元素值满足 空间复杂度：，时间复杂度 
// 注意：
// 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c） 解集中不能包含重复的三元组。 例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, -10, 20),(-10, 0, 10)

// Related Topics 数组 双指针 排序 
//示例:
//输入:[0]
//输出:[]
//

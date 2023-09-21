package nowcoder.editor.cn;
/**
 * nowcoder题目：合并两个有序的数组
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-08 17:04:13
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)

import java.util.*;

public class BM87merge {
    public void merge(int numsA[], int m, int numsB[], int n) {
        for (int i = n + m - 1, k = m - 1, j = n - 1; i >= 0; i--) {
            if (k >= 0 && j >= 0) {
                if (numsA[k] >= numsB[j]) {
                    numsA[i] = numsA[k--];
                } else {
                    numsA[i] = numsB[j--];
                }
            } else if (k >= 0) {
                numsA[i] = numsA[k--];
            } else if (j >= 0) {
                numsA[i] = numsB[j--];
            }
        }
    }
//nowcoder submit region end(Prohibit modification and deletion)

}

//给出一个有序的整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组 
// 数据范围： ，， 
// 注意：
// 1.保证 A 数组有足够的空间存放 B 数组的元素， A 和 B 中初始的元素数目分别为 m 和 n，A的数组空间大小为 m+n 2.不要返回合并的数组，
//将数组 B 的数据合并到 A 里面就好了，且后台会自动将合并后的数组 A 的内容打印出来，所以也不需要自己打印 3. A 数组在[0,m-1]的范围也是有序的 
//
// Related Topics 数组 双指针 
//示例:
//输入:[4,5,6],[1,2,3]
//输出:[1,2,3,4,5,6]
//

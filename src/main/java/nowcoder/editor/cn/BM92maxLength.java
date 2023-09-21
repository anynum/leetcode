package nowcoder.editor.cn;
/**
 * nowcoder题目：最长无重复子数组
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-08 17:48:14
 * nowcoder通过：？
 */

import com.google.common.escape.Escaper;
//nowcoder submit region begin(Prohibit modification and deletion)

import java.util.*;


public class BM92maxLength {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        int l = 0, r = 0, ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                ans = Math.max(ans, set.size());
                while (arr[l] != arr[i]) {
                    set.remove(arr[l]);
                    l++;
                }
                l++;
            } else {
                set.add(arr[i]);
            }
        }
        return Math.max(ans, set.size());
    }
//nowcoder submit region end(Prohibit modification and deletion)

}

//给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。 子数组是连续的，比如[1,3,5,7,9]的子数组有[
//1,3]，[3,5,7]等等，但是[1,3,7]不是子数组 
// 数据范围：， 
// Related Topics 哈希 双指针 数组 
//示例:
//输入:[2,3,4,5]
//输出:4 
//

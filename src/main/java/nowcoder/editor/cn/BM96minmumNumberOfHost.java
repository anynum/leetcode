package nowcoder.editor.cn;
/**
 * nowcoder题目：主持人调度（二）
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-08 10:17:38
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)
import java.util.*;


public class BM96minmumNumberOfHost {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算成功举办活动需要多少名主持人
     * @param n int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost (int n, int[][] startEnd) {

        Arrays.sort(startEnd, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < startEnd.length; i++) {


        }
        return 0;

        // write code here
    }
//nowcoder submit region end(Prohibit modification and deletion)

}

//有 n ;个活动即将举办，每个活动都有开始时间与活动的结束时间，第 i ;个活动的开始时间是 starti ,第 i ;个活动的结束时间是 endi ,举办
//某个活动就需要为该活动准备一个活动主持人。 一位活动主持人在同一时间只能参与一个活动。并且活动主持人需要全程参与活动，换句话说，一个主持人参与了第 i ;个活动
//，那么该主持人在 (starti,endi) ;这个时间段不能参与其他任何活动。求为了成功举办这 n ;个活动，最少需要多少名主持人。 数据范围: ， 复杂度要
//求：时间复杂度 ，空间复杂度 
// Related Topics 贪心 
//示例:
//输入:2,[[1,2],[2,3]]
//输出:1 
//

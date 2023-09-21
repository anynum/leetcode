package nowcoder.editor.cn;
/**
 * nowcoder题目：合并区间
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 15:59:24
 * nowcoder通过：？
 */
import com.common.entity.Interval;
//nowcoder submit region begin(Prohibit modification and deletion)

import java.util.*;



public class BM89merge {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param intervals Interval类ArrayList 
     * @return Interval类ArrayList
     */
    public ArrayList<Interval> merge (ArrayList<Interval> intervals) {
        if (intervals.size()==0){
            return intervals;
        }
        intervals.sort((o1, o2) -> o1.start - o2.start);
        ArrayList<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            Interval cur = list.get(list.size() - 1);
            if (tmp.start <= cur.end){
                // start 在上一个区间内；
                if (tmp.end <= cur.end){
                    continue;
                } else {
                    cur.end = tmp.end;
                }
            } else {
                list.add(tmp);
            }
        }
        return list;
        // write code here
    }
//nowcoder submit region end(Prohibit modification and deletion)

}

//给出一组区间，请合并所有重叠的区间。 请保证合并后的区间按区间起点升序排列。 
// 数据范围：区间组数 ，区间内 的值都满足 要求：空间复杂度 ，时间复杂度 进阶：空间复杂度 ，时间复杂度 
// Related Topics 排序 数组 
//示例:
//输入:[[10,30],[20,60],[80,100],[150,180]]
//输出:[[10,60],[80,100],[150,180]]
//

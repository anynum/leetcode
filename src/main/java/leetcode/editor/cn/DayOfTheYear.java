package leetcode.editor.cn;

import java.time.LocalDate;

/**
 * /**
 * 题目：一年中的第几天
 * 题目编号：1154
 * 时间：2023-09-01 10:58:14
 * 通过：true
 */
public class DayOfTheYear {
    public static void main(String[] args) {
        Solution solution = new DayOfTheYear().new Solution();
        int i = solution.dayOfYear("2019-01-09");
        System.out.println("i = " + i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int dayOfYear(String date) {
            LocalDate day = LocalDate.parse(date);
            return day.getDayOfYear();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。 
//
// 
//
// 示例 1： 
//
// 
//输入：date = "2019-01-09"
//输出：9
//解释：给定日期是2019年的第九天。 
//
// 示例 2： 
//
// 
//输入：date = "2019-02-10"
//输出：41
// 
//
// 
//
// 提示： 
//
// 
// date.length == 10 
// date[4] == date[7] == '-'，其他的 date[i] 都是数字 
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日 
// 
//
// Related Topics 数学 字符串 👍 115 👎 0

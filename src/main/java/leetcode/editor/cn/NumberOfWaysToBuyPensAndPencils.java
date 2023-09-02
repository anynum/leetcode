package leetcode.editor.cn;

/**
 * /**
 * 题目：买钢笔和铅笔的方案数
 * 题目编号：2240
 * 时间：2023-09-01 10:04:39
 * 通过：true
 */
public class NumberOfWaysToBuyPensAndPencils {
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysToBuyPensAndPencils().new Solution();
        long l = solution.waysToBuyPensPencils(100000, 1, 1);
        System.out.println("l = " + l);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long waysToBuyPensPencils(int total, int cost1, int cost2) {

            int penNums = total / cost1;
            long res = 0;// long接收，否则越界
            for (int i = 0; i <= penNums; i++) {
                int rest = total - cost1 * i;
                res += rest / cost2 + 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格。你可以花费你部分或者全部的
//钱，去买任意数目的两种笔。 
//
// 请你返回购买钢笔和铅笔的 不同方案数目 。 
//
// 
//
// 示例 1： 
//
// 输入：total = 20, cost1 = 10, cost2 = 5
//输出：9
//解释：一支钢笔的价格为 10 ，一支铅笔的价格为 5 。
//- 如果你买 0 支钢笔，那么你可以买 0 ，1 ，2 ，3 或者 4 支铅笔。
//- 如果你买 1 支钢笔，那么你可以买 0 ，1 或者 2 支铅笔。
//- 如果你买 2 支钢笔，那么你没法买任何铅笔。
//所以买钢笔和铅笔的总方案数为 5 + 3 + 1 = 9 种。
// 
//
// 示例 2： 
//
// 输入：total = 5, cost1 = 10, cost2 = 10
//输出：1
//解释：钢笔和铅笔的价格都为 10 ，都比拥有的钱数多，所以你没法购买任何文具。所以只有 1 种方案：买 0 支钢笔和 0 支铅笔。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= total, cost1, cost2 <= 10⁶ 
// 
//
// Related Topics 数学 枚举 👍 38 👎 0


/**
 *
 */
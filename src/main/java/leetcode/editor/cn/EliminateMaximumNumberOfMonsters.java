package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目：消灭怪物的最大数量
 * 题目编号：1921
 * 时间：2023-09-03 00:30:29
 * 通过：？
 */
public class EliminateMaximumNumberOfMonsters {
    public static void main(String[] args) {
        Solution solution = new EliminateMaximumNumberOfMonsters().new Solution();

        int[] dist = {4,3,4};
        int[] speed = {1,1,2};

        //输入：dist = [3,2,4], speed = [5,3,2]

        int i = solution.eliminateMaximum(dist, speed);
        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        if (dist.length <= 1) {
            return dist.length;
        }
        int[] arrivalTime = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            // 这里要向上取整，但是由于 / 本来就是向下取整的，所以分子减一后，向下取整，在加一
            arrivalTime[i] = (int) Math.ceil((dist[i] - 1) / speed[i] + 1);
        }

        Arrays.sort(arrivalTime);
        int res = 0;
        for (res = 2; res <= dist.length; res++) {
            if (arrivalTime[res - 1] < res) {
                return res - 1;
            }
        }
        return dist.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//你正在玩一款电子游戏，在游戏中你需要保护城市免受怪物侵袭。给你一个 下标从 0 开始 且长度为 n 的整数数组 dist ，其中 dist[i] 是第 i 
//个怪物与城市的 初始距离（单位：米）。 
//
// 怪物以 恒定 的速度走向城市。给你一个长度为 n 的整数数组 speed 表示每个怪物的速度，其中 speed[i] 是第 i 个怪物的速度（单位：米/分
//）。 
//
// 怪物从 第 0 分钟 时开始移动。你有一把武器，并可以 选择 在每一分钟的开始时使用，包括第 0 分钟。但是你无法在一分钟的中间使用武器。这种武器威力惊人
//，一次可以消灭任一还活着的怪物。 
//
// 一旦任一怪物到达城市，你就输掉了这场游戏。如果某个怪物 恰 在某一分钟开始时到达城市，这会被视为 输掉 游戏，在你可以使用武器之前，游戏就会结束。 
//
// 返回在你输掉游戏前可以消灭的怪物的 最大 数量。如果你可以在所有怪物到达城市前将它们全部消灭，返回 n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：dist = [1,3,4], speed = [1,1,1]
//输出：3
//解释：
//第 0 分钟开始时，怪物的距离是 [1,3,4]，你消灭了第一个怪物。
//第 1 分钟开始时，怪物的距离是 [X,2,3]，你没有消灭任何怪物。
//第 2 分钟开始时，怪物的距离是 [X,1,2]，你消灭了第二个怪物。
//第 3 分钟开始时，怪物的距离是 [X,X,1]，你消灭了第三个怪物。
//所有 3 个怪物都可以被消灭。 
//
// 示例 2： 
//
// 
//输入：dist = [1,1,2,3], speed = [1,1,1,1]
//输出：1
//解释：
//第 0 分钟开始时，怪物的距离是 [1,1,2,3]，你消灭了第一个怪物。
//第 1 分钟开始时，怪物的距离是 [X,0,1,2]，你输掉了游戏。
//你只能消灭 1 个怪物。
// 
//
// 示例 3： 
//
// 
//输入：dist = [3,2,4], speed = [5,3,2]
//输出：1
//解释：
//第 0 分钟开始时，怪物的距离是 [3,2,4]，你消灭了第一个怪物。
//第 1 分钟开始时，怪物的距离是 [X,0,2]，你输掉了游戏。 
//你只能消灭 1 个怪物。
// 
//
// 
//
// 提示： 
//
// 
// n == dist.length == speed.length 
// 1 <= n <= 10⁵ 
// 1 <= dist[i], speed[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 排序 👍 31 👎 0

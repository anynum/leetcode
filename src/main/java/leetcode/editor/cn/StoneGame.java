package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目：石子游戏
 * 题目编号：877
 * 时间：2023-09-22 15:52:27
 * 通过：？
 */
public class StoneGame {
    public static void main(String[] args) {
        Solution solution = new StoneGame().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] cache = new int[500][500];

        public boolean stoneGame(int[] piles) {
            int len = piles.length;
            int sum = Arrays.stream(piles).sum();
            // Alice拿第一堆和最后一堆时能拿到的最多石子
            int max = Math.max(
                    // Alice拿第一堆，
                    getMaxLR(1, len - 1, piles) + piles[0],
                    // Alice拿最后一堆时能拿到的最多石子
                    getMaxLR(0, len - 2, piles) + piles[len - 1]);
            return max > sum - max;
        }

        /**
         *
         * @param l 左边界
         * @param r 右边界
         * @param piles
         * @return
         */
        private int getMaxLR(int l, int r, int[] piles) {
            if (cache[l][r] != 0) {
                return cache[l][r];
            }
            if (r - l == 1) {
                int last = Math.max(piles[l], piles[r]);
                cache[l][r] = last;
                return last;
            }
            int max = Math.max(
                    getMaxLR(l + 1, r, piles) + piles[l],
                    getMaxLR(l, r - 1, piles) + piles[r]);
            cache[l][r] = max;

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
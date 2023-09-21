package nowcoder.editor.cn;

/**
 * nowcoder题目：二维数组中的查找
 * nowcoder题目编号：${question.frontendQuestionId}
 * nowcoder时间：2023-09-07 14:47:53
 * nowcoder通过：？
 */
//nowcoder submit region begin(Prohibit modification and deletion)


public class NC29Find {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param target int整型
     * @param array  int整型二维数组
     * @return bool布尔型
     */
    public boolean Find(int target, int[][] array) {
        int x1 = 0, y1 = 0, x2 = array.length - 1, y2 = array[0].length - 1;

        return binarySearch(array, target, x1, y1, x2, y2);

        // write code here
    }

    private boolean binarySearch(int[][] array, int target, int x1, int y1, int x2, int y2) {
        if (x1 <= x2 && y1 <= y2) {
            int midx = (x1 + x2) / 2;
            int midy = (y1 + y2) / 2;

            if (array[midx][midy] == target) {
                return true;
            } else if (array[midx][midy] < target) {
                return binarySearch(array, target, x1, midy + 1, x2, y2)
                        ||
                        binarySearch(array, target, midx + 1, y1, x2, midy);
            } else {
                return binarySearch(array, target, x1, y1, x2, midy - 1)
                        ||
                        binarySearch(array, target, x1, midy, midx - 1, y2);
            }

        }
        return false;
    }

//nowcoder submit region end(Prohibit modification and deletion)

}


//在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个
//二维数组和一个整数，判断数组中是否含有该整数。 [ [1,2,8,9],
// [2,4,9,12],
// [4,7,10,13],
// [6,8,11,15]
// ] 给定 target = 7，返回 true。 给定 target = 3，返回 false。 
// 数据范围：矩阵的长宽满足 ， 矩阵中的值满足 
// 进阶：空间复杂度 ，时间复杂度 
// 
// Related Topics 数组 
//示例:
//输入:7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
//输出:true
//

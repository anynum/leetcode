package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目：二叉树寻路
 * 题目编号：1104
 * 时间：2023-09-03 01:58:01
 * 通过：？?????
 */
public class PathInZigzagLabelledBinaryTree {
    public static void main(String[] args) {
        Solution solution = new PathInZigzagLabelledBinaryTree().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            ArrayList<Integer> integers = new ArrayList<>();//0.初始化存放结果的变量
            int a = (int) (Math.log(label) / Math.log(2));//2.计算label所在的层
            while (label > 1) {//5.循环直到遇到特殊情况1
                integers.add(label);//3.将label的结果添加到数组中
                label = (int) (3 * Math.pow(2, --a) - label / 2 - 1);//4.计算下一个label的值
            }
            integers.add(1);//6.添加特殊情况 1
            Collections.reverse(integers); //7.翻转数组
            return integers;//1.返回结果
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。 
//
// 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记； 
//
// 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。 
//
// 
//
// 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。 
//
// 
//
// 示例 1： 
//
// 输入：label = 14
//输出：[1,3,4,14]
// 
//
// 示例 2： 
//
// 输入：label = 26
//输出：[1,2,6,10,26]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= label <= 10^6 
// 
//
// Related Topics树 | 数学 | 二叉树 
//
// 👍 203, 👎 0 
//
//
//
//

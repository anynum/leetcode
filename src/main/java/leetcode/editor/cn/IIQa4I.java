package leetcode.editor.cn;

import java.util.Stack;

/**
 * 题目：每日温度
 * 题目编号：LCR 038
 * 时间：2023-09-03 23:15:13
 * 通过：？
 */
public class IIQa4I{
  public static void main(String[] args) {
       Solution solution = new IIQa4I().new Solution();
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int[] dailyTemperatures(int[] temperatures) {
          int[] ans = new int[temperatures.length];
          Stack<Integer> stack = new Stack<>();
          for (int i = 0; i < temperatures.length; i++) {
              while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i])
                  ans[stack.peek()] = i - stack.pop();
              stack.push(i);
          }
          return ans;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}


//请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不
//会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// 
//
// 
// 注意：本题与主站 739 题相同： https://leetcode-cn.com/problems/daily-temperatures/ 
//
// Related Topics 栈 数组 单调栈 👍 97 👎 0
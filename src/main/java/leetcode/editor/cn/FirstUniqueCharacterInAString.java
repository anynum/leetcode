package leetcode.editor.cn;

/**
 * /**
 * 题目：字符串中的第一个唯一字符
 * 题目编号：387
 * 时间：2023-08-29 22:52:32
 * 通过：true
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        String s = "a good   example";
        String[] s1 = s.split("\\s+");
        System.out.println(
        );


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            int[] dict = new int[128];
            for (int i = 0; i < s.length(); i++) {
                dict[s.charAt(i)]++;
            }

            for (int i = 0; i < s.length(); i++) {
                if (dict[s.charAt(i)] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 693 👎 0

package leetcode.editor.cn;

/**
 * 题目：比较版本号
 * 题目编号：165
 * 时间：2023-09-03 17:34:20
 * 通过：？
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        Solution solution = new CompareVersionNumbers().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * "1.0"
         * "1.0.0"
         */
        public int compareVersion(String version1, String version2) {

            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");

            int len1 = v1.length;
            int len2 = v2.length;

            int min = Math.max(v1.length, v2.length);
//        int i = 0, k = 0;

            for (int i = 0; i < min; i++) {
                int a = 0;
                int b = 0;
                if (i < len1) {
                    a = Integer.parseInt(v1[i]);
                }
                if (i < len2) {
                    b = Integer.parseInt(v2[i]);

                }
                if (a != b) {
                    return a > b ? 1 : -1;
                }
            }
            return 0;
        }

        public int compareVersionV2(String version1, String version2) {

            // 两个字符串的长度
            int n = version1.length(), m = version2.length();

            int i = 0;
            int j = 0;

            while (i < n || j < m) {
                // 用v1,v2来计算每一个块中版本号的大小
                int v1 = 0;
                int v2 = 0;

                // 若当前的字符不是分隔符，则计算
                while (i < n && version1.charAt(i) != '.') {
                    v1 = v1 * 10 + version1.charAt(i) - '0';
                    i++;
                }

                while (j < m && version2.charAt(j) != '.') {
                    v2 = v2 * 10 + version2.charAt(j) - '0';
                    j++;
                }
                // 判断当前块中的版本号是否一致
                if (v1 != v2) {
                    return v1 > v2 ? 1 : -1;
                }
                // 跳过分隔符
                i++;
                j++;
            }

            // 全部比较完了，没有不等的则返回0
            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你两个版本号 version1 和 version2 ，请你比较它们。 
//
// 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编
//号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。 
//
// 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。
//如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别
//为 0 和 1 ，0 < 1 。 
//
// 返回规则如下： 
//
// 
// 如果 version1 > version2 返回 1， 
// 如果 version1 < version2 返回 -1， 
// 除此之外返回 0。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：version1 = "1.01", version2 = "1.001"
//输出：0
//解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
// 
//
// 示例 2： 
//
// 
//输入：version1 = "1.0", version2 = "1.0.0"
//输出：0
//解释：version1 没有指定下标为 2 的修订号，即视为 "0"
// 
//
// 示例 3： 
//
// 
//输入：version1 = "0.1", version2 = "1.1"
//输出：-1
//解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < 
//version2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= version1.length, version2.length <= 500 
// version1 和 version2 仅包含数字和 '.' 
// version1 和 version2 都是 有效版本号 
// version1 和 version2 的所有修订号都可以存储在 32 位整数 中 
// 
//
// Related Topics 双指针 字符串 👍 389 👎 0

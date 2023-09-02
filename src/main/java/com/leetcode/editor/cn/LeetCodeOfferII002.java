package com.leetcode.editor.cn;

/* 二进制加法 */
public class LeetCodeOfferII002 {
    public static void main(String[] args) {

        String a = "111111";
        String b = "1000111011";

        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b) {
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();

        StringBuilder sb = new StringBuilder();
        int carr = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            char var1 = i < 0 ? '0' : chars1[i];
            char var2 = j < 0 ? '0' : chars2[j];
            int tmp = carr + var1 + var2 - 2 * 48;
            if (tmp > 1) {
                carr = 1;
                sb.append(tmp % 2);
            } else {
                carr = 0;
                sb.append(tmp);
            }
        }
        if (carr == 1) {
            sb.append(carr);
        }
        return sb.reverse().toString();
    }

}

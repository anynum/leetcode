package leetcode.editor.cn.match;

import com.alibaba.fastjson.JSON;
import org.apache.commons.validator.Var;

import java.util.ArrayList;
import java.util.List;

public class Match361 {
    public static void main(String[] args) {
//        countSymmetricIntegers(1229, 1230);// 1203, 1212,1221,1230
        int i = minimumOperations("25"); // 7 - 5 - 1
        System.out.println("i = " + i);

    }

    public static int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            if (s.length() % 2 == 0){
                int pre = 0;
                int tmp = i;
                for (int k = 0; k < s.length() / 2; k++) {
                    pre += tmp % 10;
                    tmp = tmp / 10;
                }
                int post = 0;
                for (int k = s.length() / 2; k < s.length(); k++) {
                    post += tmp % 10;
                    tmp = tmp / 10;
                }
                if (pre == post){
                    res++;
                    System.out.println("post = " + i);
                }
            }
        }
        return res;
    }

    public static int minimumOperations(String num) {
        int res = 0;
        int index0 = -1, rm0 = 0;
        int index5 = -1, rm5 = 0;

        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            switch (c){
                case '0':
                    if (index0 == -1){
                        rm0 = num.length() - i - 1;
                        index0 = i;
                    } else {
                        return index0 - i - 1 + rm0;
                    }
                    break;
                case '5':
                    if (index5 == -1){
                        rm5 = num.length() - i - 1;
                        index5 = i;
                    }
                    if (index0 != -1){
                        return index0 - i - 1 + rm0;
                    }
                    break;
                case '2':
                case '7':
                    if (index5 != -1){
                        return index5 - i  - 1 + rm5;
                    }
                    break;
            }
        }
        return index0 == -1 ? num.length() : num.length() - 1;
    }

    public static int minimumOperations2(String num) {
        int res = 0;
        int i = 0;
        boolean isZero = false;
        for (i = num.length() - 1; i > 0; i--) {
            char c = num.charAt(i);
            if (c != '0' && c != '5') {
                res++;
            } else if (c == '0'){
                isZero = true;
                i--;
                break;
            } else if (c == '5'){
                i--;
                break;
            }
        }
        for (; i > 0; i--) {
            char c = num.charAt(i);
            if ((c == '0' || c == '5') && isZero){
                return res;
            } else if ((c == '2' || c == '7') && !isZero){
                return res;
            } else {
                res++;
            }
        }
        return res;
    }
}

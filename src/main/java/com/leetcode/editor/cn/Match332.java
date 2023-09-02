package com.leetcode.editor.cn;

import java.util.Arrays;

public class Match332 {
    public static void main(String[] args) {
        int integer = Integer.parseInt(0 + String.valueOf(100));
        System.out.println("integer = " + integer);

        int[] nums = {0, 1, 7, 4, 4, 5};
//        findTheArrayConcVal(nums);
        long l = countFairPairs(nums, 3, 6);
        System.out.println("l = " + l);

    }


    // 2 - 7
    // 1,2,3,4,5,6,7,8,9

    //  -13,-7,-7,-5,-5,-4   -12,-12
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int res = 0, l = 0, r = nums.length - 1, tmp = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (nums[l] > 0 && sum < lower) {
                break;
            } else if (nums[r] < 0 && sum > upper) {
                break;
            }
            if (sum > upper) {
                r--;
                tmp = r;
            } else if (sum < lower) {
                l++;
                r = tmp;
            } else {
                res++;
                r--;
            }
        }
        return res;
    }

    public static long findTheArrayConcVal(int[] nums) {
        int l = 0, r = nums.length - 1;
        long res = 0;

        while (l < r) {
            String s = nums[l] + String.valueOf(nums[r]);
            long integer = Long.parseLong(s);
            res += integer;
            l++;
            r--;
        }
        if (l == r) {
            res += nums[l];
        }
        return res;

    }


}

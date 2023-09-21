package leetcode.editor.cn.match;

import java.util.Arrays;
import java.util.List;

public class Match113 {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(5, 10, 1, 5, 2);
//        sumIndicesWithKSetBits(list, 1);
        List<Integer> list2 = Arrays.asList(1,1);
        int i = countWays(list2);
        System.out.println("i = " + i);


    }

    public int countPairs(List<List<Integer>> coordinates, int p) {
        int length = coordinates.size();
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int k = i + 1; k < length; k++) {
                int xor = coordinates.get(i).get(0) ^ coordinates.get(k).get(0) + coordinates.get(i).get(1) ^ coordinates.get(k).get(1);
                if (xor == k) {
                    res++;
                }
            }
        }
        return res;
    }


    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if(Integer.bitCount(i) == k){
                res += nums.get(i);
            }
        }
        return res;
    }

    public static int countWays(List<Integer> nums) {
        int recursive = recursive(nums, 0, 0, 0);
        return recursive;
    }


    private static int recursive(List<Integer> nums, int selected, int begin, int min){
        if (begin >= nums.size()){
            if (selected < min){

            }
            return 1;
        }
        Integer cur = nums.get(begin);
        // 被选中
        int count = 0;
        count += recursive(nums, selected + 1, begin + 1, Math.max(min, cur+1));

        // 不被选中
        if (cur > selected){
            count += recursive(nums, selected, begin + 1, min);
        }
        return count;
    }
}

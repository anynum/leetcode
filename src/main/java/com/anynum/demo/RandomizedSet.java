package com.anynum.demo;

import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    HashMap<Integer, Integer> map;
    int [] nums = new int[200000];
    Random random;
    int index = -1;

    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        nums[++index] = val;
        map.put(val,index);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        Integer location = map.remove(val);
        if (location != index) {
            // 将当前位置元素和最后一个替换
            nums[location] = nums[index];
            map.put(nums[location],location);
        }
        index--;
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(index+1);
        return nums[i];
    }
}
package com.alibaba.coin.demo.annotation;

import lombok.Data;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@MySetterGetter  // 打上我们的注解
@Data
public class Test {
    private String wzj;

    public static void main(String[] args) {
        try {

            System.out.println(3 >>> 2);
            // 4294967295
            int maxValue = Integer.MAX_VALUE;
            HashMap<String, String> map = new HashMap<String,String>(4,1.0f);
            ThreadLocalRandom random = ThreadLocalRandom.current();
            while (true){
                int i = random.nextInt(1000000000);
                String key = String.valueOf(i);
                map.put(key, key);
            }


//            Class<?> clazz = Class.forName("com.alibaba.coin.demo.leetcode.dp.LeetCode9");
//            Object o = clazz.newInstance();
//
//            boolean flag;
//            flag = null;


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
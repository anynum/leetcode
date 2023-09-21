package com.anynum.demo.util;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guopeng.Zgp 2022.05.23
 */
public class MapUtils {

    /**
     * 拆分map
     * @param originMap
     * @param partitionNum
     * @return
     */
    public static List<Map<String, Map<String, JSONObject>>> splitDataMap(Map<String, Map<String, JSONObject>> originMap, int partitionNum) {
        int size = originMap.size();
        // 拆分的每个map的entry数量,需要向上取整
        int partitionSize = Double.valueOf(Math.ceil(size * 1.0 / partitionNum)).intValue();
        if (partitionSize >= size || partitionSize <= 0) {
            return Arrays.asList(originMap);
        }

        int count = 1;
        int innerCount = 1;
        List<Map<String, Map<String, JSONObject>>> splitedDataMapList = new ArrayList<>();
        Map<String, Map<String, JSONObject>> tempMap = new HashMap<>();
        for (Map.Entry<String, Map<String, JSONObject>> entry : originMap.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
            innerCount++;
            count++;
            // 当tmpMap中entry数到达partitionSize或者originMap遍历完成
            if (innerCount > partitionSize || count > size) {
                innerCount = 1;
                Map<String, Map<String, JSONObject>> batchedMap = new HashMap<>(tempMap);
                splitedDataMapList.add(batchedMap);
                tempMap.clear();
            }
        }
        return splitedDataMapList;
    }

    public static void split(){
        System.out.println("true = " + true);
    }

}

package leetcode.editor.cn.utils;

import com.alibaba.fastjson.JSONObject;
import leetcode.editor.cn.entity.ListNode;
import leetcode.editor.cn.entity.TreeNode;

import java.util.*;

public class LeetCodeUtils {

    public static ListNode array2ListNode(int[] nums){
        ListNode tmp = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(nums[i]);
            node.next = tmp;
            tmp = node;
        }
        return tmp;
    }

    public static void array2Tree(Object[] nums) {
        TreeNode treeNode = new TreeNode();
        Stack<TreeNode> stack = new Stack();
        stack.push(treeNode);
        int index = 0;
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (nums[index] != null){
                pop.val = Integer.parseInt(nums[index++].toString());
            }

        }
    }

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
}

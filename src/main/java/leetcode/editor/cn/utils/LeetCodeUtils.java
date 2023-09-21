package leetcode.editor.cn.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.entity.ListNode;
import com.common.entity.TreeNode;

import java.util.*;

public class LeetCodeUtils {

    public static ListNode array2ListNode(int[] nums) {
        ListNode tmp = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(nums[i]);
            node.next = tmp;
            tmp = node;
        }
        return tmp;
    }


    public static void printListNode(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        System.out.println(JSON.toJSONString(list));
    }



    public static TreeNode array2Tree(Object[] array, int index) {
        TreeNode treeNode = null;
        if (index < array.length) {
            Integer value = (Integer) array[index];
            if (value == null) {
                return null;
            }
            treeNode = new TreeNode(value);
            treeNode.left = array2Tree(array, 2 * index + 1);
            treeNode.right = array2Tree(array, 2 * index + 2);
            return treeNode;
        }
        return null;
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

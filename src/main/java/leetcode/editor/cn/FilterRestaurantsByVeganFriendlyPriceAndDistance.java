package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 题目：餐厅过滤器
 * 题目编号：1333
 * 时间：2023-09-27 13:39:19
 * 通过：？
 */
public class FilterRestaurantsByVeganFriendlyPriceAndDistance {
    public static void main(String[] args) {
        Solution solution = new FilterRestaurantsByVeganFriendlyPriceAndDistance().new Solution();
        // int[] nums1 = { };
        // int[] nums2 = { };
        int[][] nums = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};

        // [4,2,3,1,5]
        List<Integer> integers = solution.filterRestaurants(nums, 0, 50, 10);
        System.out.println("integers = " + JSON.toJSONString(integers));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            List<int[]> list = Arrays.asList(restaurants);
            // 不稳定排序
            List<Integer> collect = list.stream()
                    .filter(restaurant -> veganFriendly == 1 ? restaurant[2] == 1 : true)
                    .filter(restaurant -> restaurant[3] <= maxPrice && restaurant[4] <= maxDistance)
                    .sorted(((Comparator<int[]>) (o1, o2) -> o2[1] - o1[1]).thenComparing((o1, o2) -> o2[0] - o1[0]))
                    .map(restaurant -> restaurant[0])
                    .collect(Collectors.toList());
            return collect;
        }


        public List<Integer> filterRestaurants2(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            List<Restaurant> restaurantList = new ArrayList<>();
            for (int[] restaurant : restaurants) {
                restaurantList.add(new Restaurant(restaurant[0], restaurant[1],
                        restaurant[2], restaurant[3], restaurant[4]));
            }

            return restaurantList.stream().filter(r -> r.veganFriendly >= veganFriendly
                            && r.price <= maxPrice && r.distance <= maxDistance)
                    .sorted((o1, o2) -> {
                        if (o1.rating == o2.rating) {
                            return o1.id - o2.id;
                        }
                        return o2.rating - o1.rating;
                    }).map(r -> r.id).collect(Collectors.toList());
        }

        private class Restaurant {
            int id;
            int rating;
            int veganFriendly;
            int price;
            int distance;

            public Restaurant(int id, int rating, int veganFriendly, int price, int distance) {
                this.id = id;
                this.rating = rating;
                this.veganFriendly = veganFriendly;
                this.price = price;
                this.distance = distance;
            }
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
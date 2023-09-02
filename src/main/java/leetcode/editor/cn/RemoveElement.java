package leetcode.editor.cn;

public class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = solution.removeElement(nums, 2);
        System.out.println("i = " + i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            for (int i = 0, j = nums.length - 1; i < nums.length;) {
                if (j < i) {
                    return i;
                }
                if (nums[j] == val) {
                    j--;
                    continue;
                }
                if (nums[i] == val) {
                    nums[i++] = nums[j--];
                } else {
                    i++;
                }
            }
            return -1;
        }

        public int removeElement2(int[] nums, int val) {
            int j = nums.length -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val){
                    swap(nums, i--, j--);
                }
            }
            return j+1;

        }

        void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
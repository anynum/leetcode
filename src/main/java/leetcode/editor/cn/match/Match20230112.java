package leetcode.editor.cn.match;

public class Match20230112 {

    public int getCommon(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int l1 = 0, l2=0;
        while (l1<length1 && l2< length2){
            if (nums1[l1] == nums2[l2]){
                return nums1[l1];
            } else if (nums1[l1] > nums2[l2]){
                l2++;
            } else {
                l1++;
            }
        }
        return -1;
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {


        return 123l;

    }

    /**
     * (x, y - x) ：向下移动x
     * (x, 2 * y) : 向上移动y
     *
     *
     * (x - y, y) ：向左移动y
     * (2 * x, y) ：向右移动x
     */

    public boolean isReachable(int targetX, int targetY) {
        int[] dpx = new int[2];



        return false;

    }

}

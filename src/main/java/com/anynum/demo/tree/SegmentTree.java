package com.anynum.demo.tree;

public class SegmentTree {
    int[] nums, tree;
    int n;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[4 * n]; // 线段树结点数不超过 4*n
        build(0, n - 1, 1);
    }

    /**
     * 构建线段树(tree数组)
     * @param s start,nums当前区间左界
     * @param t terminal,nums当前结点区间右界
     * @param i 当前区间结点下标
     */
    private void build(int s, int t, int i) {
        if (s == t) {
            tree[i] = nums[s];
            return;
        }
        int c = s + (t - s) / 2;
        build(s, c, i * 2);
        build(c + 1, t, i * 2 + 1);
        tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    // 更新 tree[i]
    private void pushUp(int i){
        tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }


    // 单点修改(驱动): nums[i] += x
    public void add(int i, int x){
        add(i, x, 0, n - 1, 1);
    }
    // 单点修改(驱动): nums[i] = x
    public void update(int i, int x){
        update(i, x, 0, n - 1, 1);
    }
    // 单点修改: nums[idx] += x
    private void add(int idx, int x, int s, int t, int i){
        if(s == t) {
            tree[i] += x; // 增量更新
            return;
        }
        int c = s + (t - s) / 2;
        if(idx <= c) add(idx, x, s, c, i * 2);
        else add(idx, x, c + 1, t, i * 2 + 1);
        pushUp(i);
    }
    // 单点修改: nums[idx] = x
    private void update(int idx, int x, int s, int t, int i){
        if(s == t) {
            tree[i] = x; // 覆盖更新
            return;
        }
        int c = s + (t - s) / 2;
        if(idx <= c) update(idx, x, s, c, i * 2);
        else update(idx, x, c + 1, t, i * 2 + 1);
        pushUp(i);
    }

    // 单点查询 (驱动): 查询 nums[i]
    public int query(int i){
        return query(i, 0, n - 1, 1);
    }
    // 单点查询 (具体): 查询 nums[i]，尾递归
    private int query(int idx, int s, int t, int i){
        if(s == t) return tree[i];
        int c = s + (t - s) / 2;
        if(idx <= c) return query(idx, s, c, i * 2);
        else return query(idx, c + 1, t, i * 2 + 1);
    }

    // 单点修改(驱动): nums[i] = x
//    public void update(int i, int x){
//        add(i, x - nums[i], 0, n - 1, 1);
//        nums[i] = x; // 实时维护 nums[i]
//    }
//    public int query(int i){ // 单点查询: 查询 nums[i]
//        return nums[i];
//    }

}


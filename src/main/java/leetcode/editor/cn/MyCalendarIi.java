package leetcode.editor.cn;

/**
 * 题目：我的日程安排表 II
 * 题目编号：731
 * 时间：2023-09-26 17:43:02
 * 通过：？
 */
public class MyCalendarIi{
  public static void main(String[] args) {
//       Solution solution = new MyCalendarIi().new Solution();
       // int[] nums1 = { };
       // int[] nums2 = { };
       
       
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class MyCalendarTwo {
      class Node {
          int ls, rs, add, max;
      }

      int N = (int)1e9, M = 120010, cnt = 1;
      Node[] tree = new Node[M];
      void update(int u, int lc, int rc, int l, int r, int v) {
          if (l <= lc && rc <= r) {
              tree[u].add += v;
              tree[u].max += v;
              return ;
          }
          lazyCreate(u);
          pushdown(u);
          int mid = lc + rc >> 1;
          if (l <= mid) update(tree[u].ls, lc, mid, l, r, v);
          if (r > mid) update(tree[u].rs, mid + 1, rc, l, r, v);
          pushup(u);
      }
      int query(int u, int lc, int rc, int l, int r) {
          if (l <= lc && rc <= r) return tree[u].max;
          lazyCreate(u);
          pushdown(u);
          int mid = lc + rc >> 1, ans = 0;
          if (l <= mid) ans = Math.max(ans, query(tree[u].ls, lc, mid, l, r));
          if (r > mid) ans = Math.max(ans, query(tree[u].rs, mid + 1, rc, l, r));
          return ans;
      }

      void lazyCreate(int u) {
          if (tree[u] == null) {
              tree[u] = new Node();
          }
          if (tree[u].ls == 0) {
              tree[u].ls = ++cnt;
              tree[tree[u].ls] = new Node();
          }
          if (tree[u].rs == 0) {
              tree[u].rs = ++cnt;
              tree[tree[u].rs] = new Node();
          }
      }

      void pushup(int u) {
          tree[u].max = Math.max(tree[tree[u].ls].max, tree[tree[u].rs].max);
      }

      void pushdown(int u) {
          tree[tree[u].ls].add += tree[u].add; tree[tree[u].rs].add += tree[u].add;
          tree[tree[u].ls].max += tree[u].add; tree[tree[u].rs].max += tree[u].add;
          tree[u].add = 0;
      }

      public boolean book(int start, int end) {
          if (query(1, 1, N + 1, start + 1, end) >= 2) return false;
          update(1, 1, N + 1, start + 1, end, 1);
          return true;
      }

  }


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
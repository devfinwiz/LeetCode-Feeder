class LazyTag {

    int add;

    LazyTag() {
        this.add = 0;
    }

    void merge(LazyTag other) {
        this.add += other.add;
    }

    boolean has() {
        return this.add != 0;
    }

    void clear() {
        this.add = 0;
    }
}

class Node {

    int min;
    int max;
    LazyTag lazy;

    Node() {
        this.min = 0;
        this.max = 0;
        this.lazy = new LazyTag();
    }
}

class SegmentTree {

    int n;
    Node[] tree;

    SegmentTree(int[] nums) {
        n = nums.length;
        tree = new Node[4 * n + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }
        build(nums, 1, n, 1);
    }

    void add(int l, int r, int val) {
        LazyTag tag = new LazyTag();
        tag.add = val;
        update(l, r, tag, 1, n, 1);
    }

    int findLast(int start, int val) {
        if (start > n) return -1;
        return find(start, n, val, 1, n, 1);
    }

    private void apply(int i, LazyTag tag) {
        tree[i].min += tag.add;
        tree[i].max += tag.add;
        tree[i].lazy.merge(tag);
    }

    private void pushDown(int i) {
        if (tree[i].lazy.has()) {
            LazyTag tag = new LazyTag();
            tag.add = tree[i].lazy.add;
            apply(i << 1, tag);
            apply((i << 1) | 1, tag);
            tree[i].lazy.clear();
        }
    }

    private void pushUp(int i) {
        tree[i].min = Math.min(tree[i << 1].min, tree[(i << 1) | 1].min);
        tree[i].max = Math.max(tree[i << 1].max, tree[(i << 1) | 1].max);
    }

    private void build(int[] nums, int l, int r, int i) {
        if (l == r) {
            tree[i].min = tree[i].max = nums[l - 1];
            return;
        }

        int mid = (l + r) >> 1;
        build(nums, l, mid, i << 1);
        build(nums, mid + 1, r, (i << 1) | 1);
        pushUp(i);
    }

    private void update(int L, int R, LazyTag tag, int l, int r, int i) {
        if (L <= l && r <= R) {
            apply(i, tag);
            return;
        }

        pushDown(i);
        int mid = (l + r) >> 1;

        if (L <= mid) update(L, R, tag, l, mid, i << 1);
        if (R > mid) update(L, R, tag, mid + 1, r, (i << 1) | 1);

        pushUp(i);
    }

    private int find(int L, int R, int val, int l, int r, int i) {

        if (tree[i].min > val || tree[i].max < val) return -1;

        if (l == r) return l;

        pushDown(i);
        int mid = (l + r) >> 1;

        if (R > mid) {
            int right = find(L, R, val, mid + 1, r, (i << 1) | 1);
            if (right != -1) return right;
        }

        if (L <= mid) {
            return find(L, R, val, l, mid, i << 1);
        }

        return -1;
    }
}

class Solution {

    public int longestBalanced(int[] nums) {

        int n = nums.length;
        int cnt = 0;

        Map<Integer, Queue<Integer>> map = new HashMap<>();

        int[] diff = new int[n];

        diff[0] = sign(nums[0]);
        map.computeIfAbsent(nums[0], k -> new LinkedList<>()).add(1);

        for (int i = 1; i < n; i++) {
            diff[i] = diff[i - 1];

            Queue<Integer> q = map.computeIfAbsent(nums[i], k -> new LinkedList<>());

            if (q.isEmpty()) {
                diff[i] += sign(nums[i]);
            }

            q.add(i + 1);
        }

        SegmentTree seg = new SegmentTree(diff);

        for (int i = 0; i < n; i++) {

            int pos = seg.findLast(i + cnt, 0);
            if (pos != -1) {
                cnt = Math.max(cnt, pos - i);
            }

            map.get(nums[i]).poll();

            int next = n + 1;
            if (!map.get(nums[i]).isEmpty()) {
                next = map.get(nums[i]).peek();
            }

            seg.add(i + 1, next - 1, -sign(nums[i]));
        }

        return cnt;
    }

    private int sign(int x) {
        return (x & 1) == 0 ? 1 : -1;
    }
}

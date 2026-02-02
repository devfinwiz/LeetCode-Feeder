class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int kk = k - 2;
        TreeMap<Integer, Integer> tree1 = new TreeMap<>();
        TreeMap<Integer, Integer> tree2 = new TreeMap<>();
        int t1size = 0;
        int t2size = 0;
        long sm = 0;
        for (int i = 1; i < k - 1; i++) {
            int x = nums[i];
            if (!tree2.isEmpty() && x >= tree2.firstKey()) {
                tree2.put(x, tree2.getOrDefault(x, 0) + 1);
                t2size++;
            }
            else {
                tree1.put(x, tree1.getOrDefault(x, 0) + 1);
                t1size++;
                sm += x;
            }
            while (t1size < kk && !tree2.isEmpty()) {
                int y = tree2.firstKey();
                tree1.put(y, tree1.getOrDefault(y, 0) + 1);
                t1size++;
                sm += y;
                int c = tree2.get(y);
                if (c == 1) tree2.remove(y);
                else tree2.put(y, c - 1);
                t2size--;
            }
            while (t1size > kk) {
                int y = tree1.lastKey();
                tree2.put(y, tree2.getOrDefault(y, 0) + 1);
                t2size++;
                int c = tree1.get(y);
                if (c == 1) tree1.remove(y);
                else tree1.put(y, c - 1);
                t1size--;
                sm -= y;
            }
        }
        long ans = sm + nums[k - 1];
        for (int i = k; i < n; i++) {
            int j = i - dist - 1;
            if (j > 0) {
                int x = nums[j];
                if (tree1.containsKey(x)) {
                    int c = tree1.get(x);
                    if (c == 1) tree1.remove(x);
                    else tree1.put(x, c - 1);
                    t1size--;
                    sm -= x;
                }
                else if (tree2.containsKey(x)) {
                    int c = tree2.get(x);
                    if (c == 1) tree2.remove(x);
                    else tree2.put(x, c - 1);
                    t2size--;
                }
                while (t1size < kk && !tree2.isEmpty()) {
                    int y = tree2.firstKey();
                    tree1.put(y, tree1.getOrDefault(y, 0) + 1);
                    t1size++;
                    sm += y;
                    int c2 = tree2.get(y);
                    if (c2 == 1) tree2.remove(y);
                    else tree2.put(y, c2 - 1);
                    t2size--;
                }
                while (t1size > kk) {
                    int y = tree1.lastKey();
                    tree2.put(y, tree2.getOrDefault(y, 0) + 1);
                    t2size++;
                    int c2 = tree1.get(y);
                    if (c2 == 1) tree1.remove(y);
                    else tree1.put(y, c2 - 1);
                    t1size--;
                    sm -= y;
                }
            }
            int addVal = nums[i - 1];
            if (!tree2.isEmpty() && addVal >= tree2.firstKey()) {
                tree2.put(addVal, tree2.getOrDefault(addVal, 0) + 1);
                t2size++;
            }
            else {
                tree1.put(addVal, tree1.getOrDefault(addVal, 0) + 1);
                t1size++;
                sm += addVal;
            }
            while (t1size < kk && !tree2.isEmpty()) {
                int y = tree2.firstKey();
                tree1.put(y, tree1.getOrDefault(y, 0) + 1);
                t1size++;
                sm += y;
                int c = tree2.get(y);
                if (c == 1) tree2.remove(y);
                else tree2.put(y, c - 1);
                t2size--;
            }
            while (t1size > kk) {
                int y = tree1.lastKey();
                tree2.put(y, tree2.getOrDefault(y, 0) + 1);
                t2size++;
                int c = tree1.get(y);
                if (c == 1) tree1.remove(y);
                else tree1.put(y, c - 1);
                t1size--;
                sm -= y;
            }
            ans = Math.min(ans, sm + nums[i]);
        }
        return ans + nums[0];
    }
}

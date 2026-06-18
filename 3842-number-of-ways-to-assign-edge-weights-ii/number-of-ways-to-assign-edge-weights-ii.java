class Solution {
    private final int mod = (int) 1e9 + 7;
    private List<Integer>[] adList;
    private List<Pair>[] lcaQueries;
    private int[] lca;
    private boolean[] vis;
    private int[] depth;
    private UnionFind uf;
    private class Pair {
        public int first;
        public int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    private class UnionFind {
        private int[] set;
        public UnionFind(int n) {
            set = new int[n];
            for (int i = 0; i < n; i++) {
                set[i] = i;
            }
        }
        int find(int u) {
            if (set[u] == u) {
                return u;
            }
            return set[u] = find(set[u]);
        }

        void merge(int u, int v) {
            int x = find(u);
            int y = find(v);
            set[x] = y;
        }
    }

    void dfs(int v, int dep, int p) {
        depth[v] = dep;

        for (int u : adList[v]) {
            if (u != p) {
                dfs(u, dep + 1, v);
            }
        }

        for (Pair node : lcaQueries[v]) {
            if (vis[node.first]) {
                int pos = node.second;
                int l = uf.find(node.first);
                lca[pos] = l;
            }
        }
        vis[v] = true;
        if (p != -1) {
            uf.merge(v, p);
        }
    }

    private int binaryExponentiation(int base, int power) {
        if (power < 0) {
            return 0;
        }
        int res = 1;
        while (power > 0) {
            if (power % 2 == 1) {
                res = (int) (((long) res * base) % mod);
            }
            base = (int) (((long) base * base) % mod);
            power /= 2;
        }
        return res;
    }
    private int distanceBetweenNode(int u, int v, int l) {
        return depth[u] + depth[v] - 2 * depth[l];
    }
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        int m = queries.length;
        adList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adList[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adList[u].add(v);
            adList[v].add(u);
        }
        lca = new int[m];
        depth = new int[n];
        uf = new UnionFind(n);
        vis = new boolean[n];
        lcaQueries = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lcaQueries[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = queries[i][0] - 1;
            int v = queries[i][1] - 1;
            lcaQueries[u].add(new Pair(v, i));
            lcaQueries[v].add(new Pair(u, i));
        }
        dfs(0, 0, -1);

        int[] solution = new int[m];

        for (int i = 0; i < m; i++) {
            int l = lca[i];
            if (queries[i][0] == queries[i][1]) {
                solution[i] = 0;
            } else {
                int distance = distanceBetweenNode(queries[i][0] - 1, queries[i][1] - 1, l);
                solution[i] = binaryExponentiation(2, distance - 1);
            }
        }
        return solution;
    }
}

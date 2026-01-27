class Solution {
    class Edge {
        int t, w;
        Edge(int t, int w) {
            this.t = t;
            this.w = w;
        }
    }
    class State {
        int node;
        int used;
        long cost;
        State(int node, int used, long cost) {
            this.node = node;
            this.used = used;
            this.cost = cost;
        }
    }
    public int minCost(int n, int[][] edges) {
        List<Edge>[] out = new ArrayList[n];
        List<Edge>[] in = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            out[i] = new ArrayList<>();
            in[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            out[e[0]].add(new Edge(e[1], e[2]));
            in[e[1]].add(new Edge(e[0], e[2]));
        }
        long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
        PriorityQueue<State> pq =new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        dist[0][0] = 0;
        pq.offer(new State(0, 0, 0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            int used = cur.used;
            long cost = cur.cost;
            if (cost > dist[u][used]) continue;
            for (Edge e : out[u]) {
                int v = e.t;
                long nc = cost + e.w;
                if (nc < dist[v][0]) {
                    dist[v][0] = nc;
                    pq.offer(new State(v, 0, nc));
                }
            }
            if (used == 0) {
                for (Edge e : in[u]) {
                    int v = e.t;
                    long nc = cost + 2L * e.w;
                    if (nc < dist[v][0]) {
                        dist[v][0] = nc;
                        pq.offer(new State(v, 0, nc));
                    }
                }
            }
        }
        long ans = Math.min(dist[n - 1][0], dist[n - 1][1]);
        return ans == INF ? -1 : (int) ans;
    }
}

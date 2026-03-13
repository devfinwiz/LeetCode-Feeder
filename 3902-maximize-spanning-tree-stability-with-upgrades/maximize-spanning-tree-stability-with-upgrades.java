class Solution {
    static class DSU {
        int[] parent;
        int[] size;
        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        boolean merge(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;
            if (size[pa] < size[pb]) {
                int temp = pa;
                pa = pb;
                pb = temp;
            }
            parent[pb] = pa;
            size[pa] += size[pb];
            return true;
        }
    }
    public int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);
        List<int[]> optional = new ArrayList<>();
        int edgesNeeded = n - 1;
        int smallestFixed = Integer.MAX_VALUE;
        for (int[] e : edges) {
            if (e[3] == 1) {
                if (!dsu.merge(e[0], e[1])) {
                    return -1;
                }
                edgesNeeded--;
                smallestFixed = Math.min(smallestFixed, e[2]);
            } else {
                optional.add(e);
            }
        }
        if (edgesNeeded == 0) return smallestFixed;
        optional.sort((a, b) -> b[2] - a[2]);
        int[] usedWeights = new int[edgesNeeded];
        int idx = 0;
        for (int[] e : optional) {
            if (dsu.merge(e[0], e[1])) {
                usedWeights[idx++] = e[2];
                edgesNeeded--;
                if (edgesNeeded == 0) break;
            }
        }
        if (edgesNeeded > 0) return -1;
        for (int i = usedWeights.length - 1; i >= 0 && k > 0; i--, k--) {
            usedWeights[i] *= 2;
        }
        Arrays.sort(usedWeights);
        return Math.min(usedWeights[0], smallestFixed);
    }
}
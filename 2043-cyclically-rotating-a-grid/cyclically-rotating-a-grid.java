class Solution {
    public int[][] rotateGrid(int[][] g, int k) {
        int m = g.length, n = g[0].length;
        for (int l = 0; l < Math.min(m, n) / 2; l++) {
            List<Integer> a = new ArrayList<>();
            for (int j = l; j < n - l; j++) a.add(g[l][j]);
            for (int i = l + 1; i < m - l - 1; i++) a.add(g[i][n - l - 1]);
            for (int j = n - l - 1; j >= l; j--) a.add(g[m - l - 1][j]);
            for (int i = m - l - 2; i > l; i--) a.add(g[i][l]);
            int s = a.size(), r = k % s, p = 0;
            Collections.rotate(a, -r);
            for (int j = l; j < n - l; j++) g[l][j] = a.get(p++);
            for (int i = l + 1; i < m - l - 1; i++) g[i][n - l - 1] = a.get(p++);
            for (int j = n - l - 1; j >= l; j--) g[m - l - 1][j] = a.get(p++);
            for (int i = m - l - 2; i > l; i--) g[i][l] = a.get(p++);
        }
        return g;
    }
}
class Solution {
    public void markGuarded(int r, int c, int[][] mat) {
        for (int i = r - 1; i >= 0; i--) {
            if (mat[i][c] == 3 || mat[i][c] == 2) break;
            mat[i][c] = 1;
        }
        for (int i = r + 1; i < mat.length; i++) {
            if (mat[i][c] == 3 || mat[i][c] == 2) break;
            mat[i][c] = 1;
        }
        for (int j = c - 1; j >= 0; j--) {
            if (mat[r][j] == 3 || mat[r][j] == 2) break;
            mat[r][j] = 1;
        }
        for (int j = c + 1; j < mat[0].length; j++) {
            if (mat[r][j] == 3 || mat[r][j] == 2) break;
            mat[r][j] = 1;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        for (int[] g : guards) {
            mat[g[0]][g[1]] = 2;
        }
        for (int[] w : walls) {
            mat[w[0]][w[1]] = 3;
        }
        for (int[] g : guards) {
            markGuarded(g[0], g[1], mat);
        }
        int cnt = 0;
        for (int[] row : mat) {
            for (int cell : row) {
                if (cell == 0) cnt++;
            }
        }
        return cnt;
    }
}

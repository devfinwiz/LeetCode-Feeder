class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long[] col = new long[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            long sum = 0;
            for (int j = 0; j < grid.length; j++) {
                sum += grid[j][i];
            }
            col[i] = sum;
        }
        long[] row = new long[grid.length];
        for (int i = 0; i < grid.length; i++) {
            long sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
            row[i] = sum;
        }
        long colSum = 0;
        for (long num : col) {
            colSum += num;
        }
        long rowSum = 0;
        for (long num : row) {
            rowSum += num;
        }
        long pre = col[0];
        long suff = colSum - pre;
        for (int i = 1; i < col.length; i++) {
            if (pre == suff) {
                return true;
            }
            pre += col[i];
            suff -= col[i];
        }
        pre = row[0];
        suff = rowSum-pre;
        for (int i=1;i<row.length;i++) {
            if (pre==suff) {
                return true;
            }
            pre += row[i];
            suff -= row[i];
        }
        return false;
    }
}
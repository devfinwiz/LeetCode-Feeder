class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long rows[] = new long[m], cols[] = new long[n], sum = 0;
        Map<Long, Integer> high = new HashMap<>(), low = new HashMap<>(), left = new HashMap<>(), right = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long cellValue = grid[i][j];
                rows[i] += cellValue;
                cols[j] += cellValue;
                high.put(cellValue, Math.min(high.getOrDefault(cellValue, Integer.MAX_VALUE), i));
                low.put(cellValue, Math.max(low.getOrDefault(cellValue, Integer.MIN_VALUE), i));
                left.put(cellValue, Math.min(left.getOrDefault(cellValue, Integer.MAX_VALUE), j));
                right.put(cellValue, Math.max(right.getOrDefault(cellValue, Integer.MIN_VALUE), j));
                sum += cellValue;
            }
        }
        long topSum = 0, bottomSum = 0;
        for (int i = 0; i < m - 1; i++) {
            topSum += rows[i];
            bottomSum = sum - topSum;
            long key = Math.abs(topSum - bottomSum);
            if (topSum == bottomSum) {
                return true;
            } else if (topSum > bottomSum) {
                if (i > 0 && high.containsKey(key) && high.get(key) <= i && n > 1) return true;
                if (i > 0 && high.containsKey(key) && (high.get(key) == 0 || high.get(key) == i) && n == 1) return true;
                if (i == 0 && (grid[i][0] == key || grid[i][n - 1] == key)) return true;
            } else {
                if (i < m - 2 && low.containsKey(key) && low.get(key) > i && n > 1) return true;
                if (i < m - 2 && low.containsKey(key) && (low.get(key) == m - 1 || low.get(key) == i + 1) && n == 1)
                    return true;
                if (i == m - 2 && (grid[i + 1][0] == key || grid[i + 1][n - 1] == key)) return true;
            }
        }
        long leftSum = 0, rightSum = 0;
        for (int j = 0; j < n - 1; j++) {
            leftSum += cols[j];
            rightSum = sum - leftSum;
            long key = Math.abs(leftSum - rightSum);
            if (leftSum == rightSum) {
                return true;
            } else if (leftSum > rightSum) {
                if (j > 0 && left.containsKey(key) && left.get(key) <= j && m > 1) return true;
                if (j > 0 && left.containsKey(key) && (left.get(key) == 0 || left.get(key) == j) && m == 1) return true;
                if (j == 0 && (grid[0][0] == key || grid[m - 1][0] == key)) return true;
            } else {
                if (j < n - 2 && right.containsKey(key) && right.get(key) > j && m > 1) return true;
                if (j < n - 2 && right.containsKey(key) && (right.get(key) == j + 1 || right.get(key) == n - 1) && m == 1)
                    return true;
                if (j == n - 2 && (grid[0][j + 1] == key || grid[m - 1][j + 1] == key)) return true;
            }
        }
        return false;
    }
}
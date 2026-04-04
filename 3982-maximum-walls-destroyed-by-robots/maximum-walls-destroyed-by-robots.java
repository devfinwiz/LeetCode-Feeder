class Solution {
    public int countWalls(int[] a, int left, int right) {
        if (left > right || a.length == 0) return 0;
        return upperBound(a, right) - lowerBound(a, left);
    }
    public int lowerBound(int[] a, int target) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    public int upperBound(int[] a, int target) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;        
        int[][] robs = new int[n][2];
        for (int i = 0; i < n; i++) {
            robs[i][0] = robots[i];
            robs[i][1] = distance[i];
        }
        Arrays.sort(robs, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(walls);
        int[] uniqueWalls = new int[walls.length];
        int uCount = 0;
        for (int i = 0; i < walls.length; i++) {
            if (i == 0 || walls[i] != walls[i - 1]) {
                uniqueWalls[uCount++] = walls[i];
            }
        }
        int baseWalls = 0;
        int[] filtered = new int[uCount];
        int fCount = 0;
        int rPtr = 0, wPtr = 0;
        while (wPtr < uCount) {
            while (rPtr < n && robs[rPtr][0] < uniqueWalls[wPtr]) {
                rPtr++;
            }
            if (rPtr < n && robs[rPtr][0] == uniqueWalls[wPtr]) {
                baseWalls++;
            }
            else {
                filtered[fCount++] = uniqueWalls[wPtr];
            }
            wPtr++;
        }
        filtered = Arrays.copyOf(filtered, fCount);
        long[][] dp = new long[n][2];
        dp[0][0] = countWalls(filtered, robs[0][0] - robs[0][1], robs[0][0] - 1);
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            int pPrev = robs[i - 1][0], dPrev = robs[i - 1][1];
            int pCurr = robs[i][0], dCurr = robs[i][1];
            int rStart = pPrev + 1;
            int rEnd = Math.min(pCurr - 1, pPrev + dPrev);
            int lStart = Math.max(pPrev + 1, pCurr - dCurr);
            int lEnd = pCurr - 1;
            long cRR = 0, cLL = 0, cRL = 0;      
            if (rStart <= rEnd) cRR = countWalls(filtered, rStart, rEnd);
            if (lStart <= lEnd) cLL = countWalls(filtered, lStart, lEnd);
            if (rStart <= rEnd && lStart <= lEnd && rEnd >= lStart) {
                cRL = countWalls(filtered, rStart, lEnd);
            } 
            else{
                cRL = cRR + cLL;
            }
            dp[i][0] = Math.max(dp[i - 1][0] + cLL, dp[i - 1][1] + cRL);
            dp[i][1] = Math.max(dp[i - 1][0] + 0, dp[i - 1][1] + cRR);
        }
        long rightEndWalls = countWalls(filtered, robs[n - 1][0] + 1, robs[n - 1][0] + robs[n - 1][1]);
        long maxDestroyed = Math.max(
            dp[n - 1][0], 
            dp[n - 1][1] + rightEndWalls
        );
        return (int) (maxDestroyed + baseWalls);
    }
}
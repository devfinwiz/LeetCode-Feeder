class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {

        int bestX = -1;
        int bestY = -1;
        int bestQuality = -1;

        for (int[] tower : towers) {
            int dist = Math.abs(tower[0] - center[0]) 
                     + Math.abs(tower[1] - center[1]);

            if (dist <= radius) {
                if (
                    tower[2] > bestQuality ||
                    (tower[2] == bestQuality &&
                     (tower[0] < bestX ||
                     (tower[0] == bestX && tower[1] < bestY)))
                ) {
                    bestX = tower[0];
                    bestY = tower[1];
                    bestQuality = tower[2];
                }
            }
        }
        return new int[]{bestX, bestY};
    }
}

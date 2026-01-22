class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[] arr = new int[7];
        HashMap<Integer, Integer> top = new HashMap<>();
        HashMap<Integer, Integer> bottom = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[tops[i]]++;
            arr[bottoms[i]]++;
            top.put(tops[i], top.getOrDefault(tops[i], 0) + 1);
            bottom.put(bottoms[i], bottom.getOrDefault(bottoms[i], 0) + 1);
        }
        int mini = -1;
        for (int i = 1; i <= 6; i++) {
            if (arr[i] >= n) {
                mini = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (tops[i] != mini && bottoms[i] != mini) {
                return -1;
            }
        }
        if (mini == -1) return -1;
        int topCount = top.getOrDefault(mini, 0);
        int bottomCount = bottom.getOrDefault(mini, 0);
        return Math.min(n - topCount, n - bottomCount);
    }
}

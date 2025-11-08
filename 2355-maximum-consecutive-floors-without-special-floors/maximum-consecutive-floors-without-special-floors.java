class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int maxGap = 0;
        maxGap = Math.max(maxGap, special[0] - bottom);
        for (int i = 1; i < special.length; i++) {
            maxGap = Math.max(maxGap, special[i] - special[i-1] - 1);
        }
        maxGap = Math.max(maxGap, top - special[special.length-1]);
        
        return maxGap;
    }
}
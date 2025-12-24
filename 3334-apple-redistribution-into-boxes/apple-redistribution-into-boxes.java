class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < apple.length; i++) sum += apple[i];
        for(int i = capacity.length - 1; i >= 0; i--) {
            sum -= capacity[i];
            ans++;
            if(sum <= 0) return ans;
        }
        return ans;
    }
}
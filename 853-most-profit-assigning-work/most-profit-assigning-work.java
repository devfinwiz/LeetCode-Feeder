class Solution {
    public int bs(int work, int low, int high, int[][] combin){
        int ans = 0;
        int ind = -1;
        while(low <= high){
            int mid = (low) + (high - low) / 2;
            if(combin[mid][0] <= work){
                ind = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        if(ind != -1){
            ans = combin[ind][1];
        }
        return ans;
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] combin = new int[difficulty.length][2];
        for(int i=0;i<difficulty.length;i++){
            combin[i][0] = difficulty[i];
            combin[i][1] = profit[i];
        }
        Arrays.sort(combin,(a,b)->a[0]-b[0]);
        for(int i=1;i<combin.length;i++){
            combin[i][1] = Math.max(combin[i][1],combin[i-1][1]);
        }
        Arrays.sort(worker);
        int prof = 0;
        for(int work:worker){
            prof += bs(work, 0, combin.length-1, combin);
        }
        return prof;
    }
}
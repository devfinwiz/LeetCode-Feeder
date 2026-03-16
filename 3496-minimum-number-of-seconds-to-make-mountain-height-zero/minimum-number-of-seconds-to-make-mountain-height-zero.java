class Solution {
    private boolean canReduce(long time, int height, int[] workers){
        long total = 0;
        for(int w : workers){
            long val = (long)(Math.sqrt(1 + (8.0 * time)/w) - 1) / 2;
            total += val;
            if(total >= height)
                return true;
        }
        return total >= height;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long)1e18;
        long ans = right;
        while(left <= right){
            long mid = (left + right) / 2;
            if(canReduce(mid, mountainHeight, workerTimes)){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
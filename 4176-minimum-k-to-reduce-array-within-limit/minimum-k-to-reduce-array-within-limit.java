class Solution {
    public long nonPositive(int[] nums, int k){
        long mov = 0;
        for(int num : nums){
            mov += (num + k - 1) / k;
        }
        return mov;
    }
    public int minimumK(int[] nums) {
        int maxx = 0;
        for(int num : nums){
            maxx = Math.max(maxx, num);
        }
        int low = 1;
        int high = Math.max(maxx, nums.length);
        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            long moves = nonPositive(nums, mid);
            if(moves <= (long) mid * mid){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

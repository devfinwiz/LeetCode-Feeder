class Solution {
    public int dominantIndices(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int lsum=nums[0];
        // int rsum=sum-nums[0];
        int rsum=sum;
        int cnt=0;
        
        for(int i=0;i<nums.length-1;i++){
            rsum-=nums[i];
            if(nums[i] > (rsum/(nums.length-i-1)))cnt++;
        }
        return cnt;
    }
}
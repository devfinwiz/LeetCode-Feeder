class Solution { 
    public int minSizeSubarray(int[] nums, int target) {
        int len = nums.length;
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        int count = target / totalSum;
        int remaining = target % totalSum;
        if(remaining == 0) return count * len;
        int minnLen = Integer.MAX_VALUE;
        int low = 0, high = 0;
        int sum = 0;
        while(high < len * 2){
            sum += nums[high % len];
            high++;
            while(sum > remaining){
                sum -= nums[low % len];
                low++;
            }
            if(sum == remaining){
                minnLen = Math.min(minnLen, high - low);
            }
        }
        return minnLen == Integer.MAX_VALUE ? -1 : count * len + minnLen;
    }
}
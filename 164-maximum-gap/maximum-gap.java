class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxx = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            maxx = Math.max(nums[i] - nums[i-1],maxx);
        }
        return maxx;
    }
}
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i+k-1<nums.length;i++){
            ans=Math.min(nums[i+k-1]-nums[i],ans);
        }
        return ans;
    }
}
class Solution {
    public int minimumOperations(int[] nums) {
        int ans=0;
        for(int num:nums){
            int remain=num%3;
            ans+=Math.min(remain,3-remain);
        }
        return ans;
    }
}
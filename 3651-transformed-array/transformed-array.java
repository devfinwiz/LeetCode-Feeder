class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] ans=new int[nums.length];
        int len=nums.length;
        for(int i=0;i<nums.length;i++){
            int ind=(i+nums[i])%len;
            if(ind<0){
                ind+=len;
            }
            ans[i]=nums[ind];
        }
        return ans;
    }
}
class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] ans=new long[nums.length];
        int maxx=nums[0];
        int j=0;
        for(int i=0;i<nums.length;i++){
            maxx=Math.max(maxx,nums[i]);
            int score=nums[i]+maxx;
            ans[j++]=score;
        }
        long prevSum=(int)ans[0];
        for(int i=1;i<ans.length;i++){
            ans[i]=ans[i]+prevSum;
            prevSum=ans[i];
        }
        return ans;
    }
}
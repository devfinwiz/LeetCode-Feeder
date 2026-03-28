class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int last1=-1,last2=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                last1=i;
                if(last2!=-1){
                    ans=Math.min(ans,Math.abs(last2-last1));    
                }
            }
            if(nums[i]==2){
                last2=i;
                if(last1!=-1){
                    ans=Math.min(ans,Math.abs(last1-last2));
                }
            }
            
        }
        return ans==Integer.MAX_VALUE?-1:Math.abs(ans);
    }
}
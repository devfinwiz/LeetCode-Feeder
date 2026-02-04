class Solution {
    public boolean isTrionic(int[] nums) {
        int p1=Integer.MAX_VALUE;
        int q=Integer.MAX_VALUE;
        int p2=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])return false;
            if(nums[i]<nums[i+1]){
                continue;
            }
            else{
                p1=i;
                break;
            }
        }
        if(p1==Integer.MAX_VALUE || p1==0) return false;
        for(int i=p1+1;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])return false;
            if(nums[i]>nums[i+1]){
                continue;
            }
            else{
                q=i;
                break;
            }
        }
        if(q==Integer.MAX_VALUE)return false;
        for(int i=q;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])return false;
            if(nums[i]<nums[i+1]){
                continue;
            }
            else{
                p2=i;
                break;
            }
        }
        return p2==Integer.MAX_VALUE;
    }    
}
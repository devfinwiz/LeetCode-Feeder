class Solution {
    public int maxRotateFunction(int[] nums) {
        int f=0;
        int n=nums.length;
        int numSum=Arrays.stream(nums).sum();
        for (int i=0;i<n;i++){
            f+=i*nums[i];
        }
        int res=f;
        for(int i=n-1;i>0;i--){
            f+=numSum-n*nums[i];
            res=Math.max(res,f);
        }
        return res;
    }
}
class Solution {
    public int scoreDifference(int[] nums) {
        boolean first=true;
        boolean second=false;
        int firstSum=0;
        int secondSum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                boolean temp=first;
                first=second;
                second=temp;
            }
            if(i%6==5){boolean temp=first;
                first=second;
                second=temp;
            }
            if(first)firstSum+=nums[i];
            else secondSum+=nums[i];
        }
        return firstSum-secondSum;
    }
}
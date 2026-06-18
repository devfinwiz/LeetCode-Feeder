class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < pivot){
                ans[index]= nums[i];
                index++;
            }
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i] == pivot){
                ans[index] = nums[i];
                index++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > pivot){
                ans[index] = nums[i];
                index++;
            }
        }
        return ans;
    }
}
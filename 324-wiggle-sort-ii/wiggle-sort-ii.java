class Solution {
    public void wiggleSort(int[] nums) {
        int[] copyNums=Arrays.copyOf(nums,nums.length);
        Arrays.sort(copyNums);
        int ind=nums.length-1;
        for(int i=1;i<nums.length;i+=2)nums[i]=copyNums[ind--];
        for(int i=0;i<nums.length;i+=2)nums[i]=copyNums[ind--];
    }
}
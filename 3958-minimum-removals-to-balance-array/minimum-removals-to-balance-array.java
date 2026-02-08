class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int count=nums.length;
        int high=0;
        for (int low=0;low<nums.length;low++) {
            while(high<nums.length&&nums[high]<=(long)nums[low]*k){
                high++;
            }
            count=Math.min(count,nums.length-(high-low));
        }
        return count;
    }
}

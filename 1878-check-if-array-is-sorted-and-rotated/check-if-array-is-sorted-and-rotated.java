class Solution {
    public boolean check(int[] nums) {
        int voilation = 0, n = nums.length;
        if(n <= 1) {
            return true;
        }
        for(int i = 1; i < n; i++) {
            if(nums[i-1] > nums[i]) {
                voilation++;
                if(voilation > 1) {
                    return false;
                }
            }
        }
        if(nums[0]<nums[n-1]) {
            voilation++;
        }
        return voilation<=1;
    }
}
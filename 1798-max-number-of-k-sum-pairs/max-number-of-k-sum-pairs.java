class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int low =0;
        int high = nums.length-1;
        int len = nums.length;
        while(low < high){
            int sum = nums[high] + nums[low];
            if(sum == k){
                cnt++;
                high--;
                low++;
            }
            else if(sum > k){
                high--;
            }
            else{
                low++;
            }
        }
        return cnt;
    }
}
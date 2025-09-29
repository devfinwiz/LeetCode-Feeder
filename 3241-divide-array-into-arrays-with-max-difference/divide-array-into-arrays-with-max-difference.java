class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        int idx = 0;
        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[idx][0] = nums[i];
            ans[idx][1] = nums[i + 1];
            ans[idx][2] = nums[i + 2];
            idx++;
        }
        return ans;
    }
}

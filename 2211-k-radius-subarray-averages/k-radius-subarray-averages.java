class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int size = 2 * k + 1;

        if (size > n) return ans;

        long sum = 0;
        for (int i = 0; i < size; i++) sum += nums[i];
        ans[k] = (int)(sum / size);

        for (int i = k + 1; i + k < n; i++) {
            sum += nums[i + k] - nums[i - k - 1];
            ans[i] = (int)(sum / size);
        }

        return ans;
    }
}

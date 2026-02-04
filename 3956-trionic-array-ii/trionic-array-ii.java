class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            long res = 0;
            while (j < n && nums[j - 1] < nums[j]) {
                j++;
            }
            int k = j - 1;
            if (k == i) {
                continue;
            }
            res += nums[k] + nums[k - 1];
            while (j < n && nums[j - 1] > nums[j]) {
                res += nums[j];
                j++;
            }
            int l = j - 1;
            if (l == k || l == n - 1 || (j < n && nums[j] <= nums[l])) {
                i = l;
                continue;
            }
            res += nums[l + 1];
            long maxSum = 0;
            long sum = 0;
            for (int m = l + 2; m < n && nums[m] > nums[m - 1]; m++) {
                sum += nums[m];
                maxSum = Math.max(maxSum, sum);
            }
            res += maxSum;
            maxSum = 0;
            sum = 0;
            for (int m = k - 2; m >= i; m--) {
                sum += nums[m];
                maxSum = Math.max(maxSum, sum);
            }
            res += maxSum;
            ans = Math.max(ans, res);
            i = l - 1;
        }
        return ans;
    }
}

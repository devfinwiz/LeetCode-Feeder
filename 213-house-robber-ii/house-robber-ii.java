class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // Case 1: Rob the first house, but not the last
        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        // Case 2: Rob the last house, but not the first
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }

        // Return the maximum amount between the two cases
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }

    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = {1, 2, 3};

        System.out.println(solution.rob(nums1));  // Output: 3
        System.out.println(solution.rob(nums2));  // Output: 4
        System.out.println(solution.rob(nums3));  // Output: 3
    }
}

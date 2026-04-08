class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int val = query[3];
            int i = l;
            while (i <= r) {
                nums[i] = (int)((long)nums[i] * val % MOD);
                i += k;
            }
        }
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
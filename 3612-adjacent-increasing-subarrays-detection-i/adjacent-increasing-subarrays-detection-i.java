class Solution {
    public boolean isStrictly(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = 0; i <= nums.size() - 2 * k; i++) {
            List<Integer> sub = nums.subList(i, i + k);
            if (isStrictly(sub)) {
                List<Integer> sub2 = nums.subList(i + k, i + 2 * k);
                if (isStrictly(sub2)) {
                    return true;
                }
            }
        }
        return false;
    }
}

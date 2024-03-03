class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the starting position
        int start = binarySearch(nums, target, true);
        if (start == nums.length || nums[start] != target) {
            return result;
        }

        // Find the ending position
        int end = binarySearch(nums, target, false) - 1;

        result[0] = start;
        result[1] = end;

        return result;
    }

    private int binarySearch(int[] nums, int target, boolean findStart) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target || (findStart && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

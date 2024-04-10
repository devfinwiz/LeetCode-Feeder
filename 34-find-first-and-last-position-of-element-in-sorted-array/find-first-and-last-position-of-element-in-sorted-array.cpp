class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        int left = 0, right = n - 1;
        int start = -1, end = -1;

        // Search for the leftmost occurrence of target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
                right = mid - 1; // continue searching on the left side
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Reset left and right pointers for finding the rightmost occurrence
        left = 0;
        right = n - 1;

        // Search for the rightmost occurrence of target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                end = mid;
                left = mid + 1; // continue searching on the right side
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return {start, end};
    }
};
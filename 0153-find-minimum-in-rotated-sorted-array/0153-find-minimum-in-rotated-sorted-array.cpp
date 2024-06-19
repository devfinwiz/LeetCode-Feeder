class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;

        // If the array is not rotated at all
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid element is the minimum
            if (nums[mid] > nums[right]) {
                // The minimum element must be in the right part
                left = mid + 1;
            } else {
                // The minimum element must be in the left part (including mid)
                right = mid;
            }
        }

        // At the end of the while loop, left == right, pointing to the minimum element
        return nums[left];
    }
};
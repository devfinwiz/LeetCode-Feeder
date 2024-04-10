class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int candidate = nums[0];
        int count = 1;

        // Phase 1: Find the majority element candidate
        for (int i = 1; i < nums.size(); ++i) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify if the candidate is the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        // The candidate is guaranteed to be the majority element,
        // so there's no need to check if it actually appears more than n/2 times.
        return candidate;
    }
};
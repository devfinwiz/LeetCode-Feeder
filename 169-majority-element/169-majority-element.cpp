class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count = 0, majority;
        for (int num : nums) {
            if (!count) {
                majority = num;
            }
            count += num == majority ? 1 : -1;
        }
        return majority;
    }
};
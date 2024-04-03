class Solution {
public:
    int singleNumber(std::vector<int>& nums) {
        int result = 0;
        
        // XOR operation cancels out elements that appear twice
        // The remaining element will be the single number
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
};
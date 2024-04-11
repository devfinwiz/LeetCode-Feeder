class Solution {
public:
    int jump(std::vector<int>& nums) {
        int n = nums.size();
        if (n == 1) return 0; // If there's only one element, no jump needed
        
        int jumps = 0;
        int currentEnd = 0; // The farthest index that can be reached with the current jump
        int farthest = 0;   // The farthest index that can be reached overall
        
        for (int i = 0; i < n - 1; ++i) {
            farthest = std::max(farthest, i + nums[i]); // Update the farthest index that can be reached
            
            if (i == currentEnd) { // Need to make another jump
                ++jumps;
                currentEnd = farthest; // Update the end of the current jump
            }
        }
        
        return jumps;
    }
};
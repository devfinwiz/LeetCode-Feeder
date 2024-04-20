class Solution {
public:
    bool canJump(std::vector<int>& nums) {
        int n = nums.size();
        int maxReachable = 0; // furthest index that can be reached
        
        for (int i = 0; i < n; ++i) {
            // If the current index is beyond the furthest index that can be reached,
            // then it's impossible to reach the end
            if (i > maxReachable) {
                return false;
            }
            // Update maxReachable if the current index plus its jump length
            // exceeds the current maxReachable index
            maxReachable = std::max(maxReachable, i + nums[i]);
            
            // If the furthest reachable index is already the last index,
            // then we can reach the end
            if (maxReachable >= n - 1) {
                return true;
            }
        }
        
        // If we haven't reached the last index by the end of the loop, 
        // it means it's impossible to reach the end
        return false;
    }
};
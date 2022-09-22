class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        set<int> s;
        for(auto i:nums)
        {
            s.insert(i);
            
        }
        if(nums.size()>s.size())
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
};
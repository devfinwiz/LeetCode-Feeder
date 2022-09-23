class Solution {
public:
    int thirdMax(vector<int>& nums) {
        
        
        int m=0;
        int ans;
        set<int>  s;
        vector<int> v;
        for(int i=0;i<nums.size();i++)
        {
            s.insert(nums[i]);
        }
        if(s.size()<=2)
        {
            return *max_element(nums.begin(),nums.end());
        }
        int siz=s.size();
        for(auto i: s)
        {
            v.push_back(i);
        }
        
        
        return v[siz-3];
        
        
        
        
        
    }
};
class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        map<int,int> m;
        vector<int> v;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]%2==0)
            {
             m.insert({nums[i],0});
            }
        }
        for(int i=0;i<nums.size();i++)
        {   
            if(nums[i]%2==0)
            {
            m[nums[i]]++;
            }
        }
        int maxi=0;
        for(auto i : m)
        {
             maxi=max(maxi,i.second);
        }
        for(auto i: m)
        {
            if(i.second==maxi)
            {
                v.push_back(i.first);
            }
                
        }
        if(maxi==0)
        {
            return -1;
        }
        else
        {
            return v[0];
        }
       
        
        
        
    }
};
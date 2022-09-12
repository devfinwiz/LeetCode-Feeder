class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int m,n;
        vector<int> v;
        for(int i=0;i<nums.size();i++)
        {
            for(int j=i;j<nums.size();j++)
            {
               
                 if(nums[i]+nums[j]==target and i!=j)
                {
                    v.push_back(i);
                    v.push_back(j);
                }
            }
        }
        return v;
        
    }
};
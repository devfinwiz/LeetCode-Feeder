class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        
        
        
        int f=0;
        int l=nums.size()-1;
        int m;
        while(f<=l)
        {
            
            m=(f+l)/2;
            if(target==nums[m])
            {
                return m;
            }
            
            else if(target<nums[m])
            {
                l=m-1; 
                
                
            }
            else if(target>nums[m])
            {
                f=m+1;
                
            }            
        }
        return l+1;
        
    }
};
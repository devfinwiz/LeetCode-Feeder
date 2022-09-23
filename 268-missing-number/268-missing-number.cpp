class Solution {
public:
    int missingNumber(vector<int>& nums) {
        unsigned long long int siz=nums.size();
        unsigned long long int ap=siz*(siz+1)/2;
        unsigned long long int sum=0;
        for(int i=0;i<nums.size();i++)
        {
            sum=sum+nums[i];
            
        }
        return ap-sum;
        
        

        
    }
};
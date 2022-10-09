class Solution {
public:
    int climbStairs(int n) {
        unsigned long long int one=1,two=1,temp;
        for(int i=0;i<n;i++)
        {   
            temp=one;
            one=one+two;
            two=temp;

        }
        return two;
        
    }
};
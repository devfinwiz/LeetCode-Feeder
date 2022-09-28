class Solution {
public:
    string multiply(string num1, string num2) {
    if(num1=="0" or num2=="0")
    {
        return "0";
    }
    else
    {
       string s3;
    vector<int> num(num1.size() + num2.size(), 0);
        
        for (int i = num1.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                num[i + j + 1] += (num1[i] - '0') * (num2[j] - '0');
                num[i + j] += num[i + j + 1] / 10;
                num[i + j + 1] %= 10;
            }
        }
        
    int flag=0;
    for(int i=0;i<num.size();i++)
    {
        if(num[i]!=0)
        {
            flag=1;

        }
        if(flag==1)
        {
            s3.push_back(num[i]+'0');
        }
    }
    return s3;
        
    }   
        
    }
};
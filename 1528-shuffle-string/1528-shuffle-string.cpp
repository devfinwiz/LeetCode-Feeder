class Solution {
public:
    string restoreString(string s, vector<int>& v) {
        map<int,char> m;
        string a="";
        for(int i=0;i<s.size();i++)
        {
            m[v[i]]=s[i];
        }
        for(auto i: m)
        {
            a=a+i.second;
        }
        return a;
        
    }
};
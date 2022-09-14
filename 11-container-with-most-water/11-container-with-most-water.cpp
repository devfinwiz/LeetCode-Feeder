class Solution {
public:
    int maxArea(vector<int>& h) 
    {
        int t=h.size();
        int i=0,j=t-1;
        int area=0;
        
        
    while(i<j)
    {
        int m=min(h[i],h[j]);
        area=max(area,m*(j-i));
        if(h[i]<h[j])
        {
            i++;
            
        }
        else
            j--;
        
    }return area;
}
};
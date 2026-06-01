class Solution {
    public int minimumCost(int[] cost) {                            
        Arrays.sort(cost);
        int ans=0;
        int cnt=1;
        for(int i=cost.length-1;i>=0;i--){
           if(cnt%3!=0)ans+=cost[i];
            cnt++;  
        }
        return ans;
    }
}
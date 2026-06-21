class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans=0;
        for(int cost:costs){
            if(coins>=cost){
                coins-=cost;
                ans++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}
class Solution {
    public int largestAltitude(int[] gain) {
        int curr=0;
        int maxx=0;
        for(int height:gain){
            curr+=height;
            maxx=Math.max(curr,maxx);
        }
        return maxx;
    }
}
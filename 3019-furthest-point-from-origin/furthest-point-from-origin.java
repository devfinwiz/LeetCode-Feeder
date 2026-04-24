class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int gaps=0,l=0,r=0;
        for(char ch:moves.toCharArray()){
            if(ch=='_') gaps++;
            if(ch=='L')l++;
            if(ch=='R')r++;
        }
        return Math.abs(r-l)+gaps;
    }
}
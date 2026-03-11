class Solution {
    public int gcd(int x,int y){
        if(x==0)return y;
        return gcd(y%x,x);
    }
    public boolean isReachable(int targetX, int targetY) {
        int g=gcd(targetX,targetY);
        return (g&(g-1))==0;
    }
}
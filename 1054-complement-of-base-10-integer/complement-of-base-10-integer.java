class Solution {
    public int bitwiseComplement(int n) {
        int x=1;
        while(x<n){
            x=(x<<1)+1;
        }
        return x^n;
    }
}
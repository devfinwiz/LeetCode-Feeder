class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat[0].length;
        k%=mat[0].length;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=mat[i][(j+k)%n]) return false;   
            }
        }
        return true;
    }
}
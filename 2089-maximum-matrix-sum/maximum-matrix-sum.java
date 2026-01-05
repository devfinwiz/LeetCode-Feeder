class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long _ve=0;
        long sum=0;
        long minii = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0) _ve++;
                minii=Math.min(minii,Math.abs(matrix[i][j]));
            }
        }
        if(_ve%2!=0){
            sum-=2*minii;
        }
        return sum;
    }
}
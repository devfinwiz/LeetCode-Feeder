class Solution {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] rowArray = new int[row];
        int[] colArray = new int[col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 1){
                    rowArray[i]++;
                    colArray[j]++;
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 1 && rowArray[i] == 1 && colArray[j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
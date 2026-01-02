class Solution {
    public int countNegatives(int[][] grid) {
        int neg = 0;
        int n = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] < 0){
                    neg++;
                }
            }
        }   
        return neg;
    }
}
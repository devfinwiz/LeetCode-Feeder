class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int total=0;
        for(int i=0;i<grid.length;i++){
            int sum=0;
            for(int j=0;j<grid[0].length;j++){
                sum+=grid[i][j];
                if(sum<=k)total++;
                if(i<grid.length-1)grid[i+1][j]+=grid[i][j];
            }
        }
        return total;
    }
}
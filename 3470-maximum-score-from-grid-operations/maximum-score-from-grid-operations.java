class Solution {
    public long maximumScore(int[][] grid) {
        MaxScoreInGrid finder=new MaxScoreInGrid();
        return finder.getMaximumScore(grid);
    }
}
class ColumnSumFinder{
    long gridPrefix[][];
    public ColumnSumFinder(int grid[][]) {
        gridPrefix=new long[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            gridPrefix[0][i]=grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                gridPrefix[j][i]=gridPrefix[j-1][i]+grid[j][i];
            }
        }
    }
    
    public String toString(){
        return Arrays.deepToString(gridPrefix);
    }
    long getColumnSum(int columNumber,int startRow,int endRow){
        if(columNumber<0 || columNumber>=gridPrefix[0].length){
            return 0;
        }
        if(startRow>=endRow){
            return 0;
        }
        long blackBoxes = ((startRow==-1)?0:gridPrefix[startRow][columNumber]);
        long whitePlusBlack = gridPrefix[endRow][columNumber];
        return whitePlusBlack-blackBoxes;
    }
}
class MaxScoreInGrid{
    int grid[][];
    ColumnSumFinder sumFinder;
    Long dp[][][];
    long getMaximumScore(int grid[][]){
        this.grid=grid;
        dp=new Long[grid[0].length][grid.length+1][2];
        sumFinder=new ColumnSumFinder(grid);
        long ans = getFromColumn(0, -1, 0);
        return ans;
    }
    long getFromColumn(int currentColumnNumber,int previousColumnFilled,int previousPreviousIsBigger){
        long ans=0;
        if(currentColumnNumber>=grid[0].length){
            return 0;
        }
        if(dp[currentColumnNumber][previousColumnFilled+1][previousPreviousIsBigger]!=null){
            return dp[currentColumnNumber][previousColumnFilled+1][previousPreviousIsBigger];
        }
        for (int currentColumnFill = -1; currentColumnFill < grid.length; currentColumnFill++) {
            long currentAnswer=0;
            currentAnswer=Math.max(currentAnswer,getFromColumn(currentColumnNumber+1, currentColumnFill, 0));
            currentAnswer=Math.max(currentAnswer,
            getFromColumn(currentColumnNumber+1, currentColumnFill, 1)
            +sumFinder.getColumnSum(
            currentColumnNumber,
            currentColumnFill,
            previousColumnFilled));
            if(previousPreviousIsBigger==0){
                currentAnswer+=sumFinder.getColumnSum(currentColumnNumber-1,previousColumnFilled, currentColumnFill);
            }
            ans=Math.max(ans,currentAnswer);
        }
        return dp[currentColumnNumber][previousColumnFilled+1][previousPreviousIsBigger]=ans;
    }
}   
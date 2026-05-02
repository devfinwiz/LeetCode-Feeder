class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        return fn(0,0,grid,vis);
    }
    public boolean fn(int i,int j,int[][] grid,boolean[][] vis){
        int n=grid.length;
        int m=grid[0].length;
        if(i==n-1 && j==m-1)return true;
        if(vis[i][j]==true)return false;
        vis[i][j]=true;
        boolean flag=false;
        if(grid[i][j]==1){
            flag=street1(i,j,grid,vis);
        }
        else if(grid[i][j]==2){
            flag=street2(i,j,grid,vis);
        }
        else if(grid[i][j]==3){
            flag=street3(i,j,grid,vis);
        }
        else if(grid[i][j]==4){
            flag=street4(i,j,grid,vis);
        }
        else if(grid[i][j]==5){
            flag=street5(i,j,grid,vis);
        }
        else if(grid[i][j]==6){
            flag=street6(i,j,grid,vis);
        }
        vis[i][j]=false;
        return flag;
    }
    public boolean street1(int i,int j ,int[][] grid,boolean[][] vis){
        boolean flag=false;
        int n=grid.length;
        int m=grid[0].length;
        if(j-1>=0){
            if(grid[i][j-1]==4 || grid[i][j-1]==6 || grid[i][j-1]==1) flag=fn(i,j-1,grid,vis);
        }
        if(j+1<m){
            if(grid[i][j+1]==3 || grid[i][j+1]==5 || grid[i][j+1]==1)flag|=fn(i,j+1,grid,vis);
        }
        return flag;
    }
    public boolean street2(int i,int j,int[][] grid,boolean[][] vis){
        boolean flag=false;
        int n=grid.length;
        int m=grid[0].length;
        if(i-1>=0){
            if(grid[i-1][j]==3 || grid[i-1][j]==4||grid[i-1][j]==2)flag=fn(i-1,j,grid,vis);
        }
        if(i+1<n){
            if(grid[i+1][j]==5 || grid[i+1][j]==6||grid[i+1][j]==2)flag|=fn(i+1,j,grid,vis);
        }
        return flag;
    }
    public boolean street3(int i,int j,int[][] grid,boolean[][] vis){
        boolean flag=false;
        int n=grid.length;
        int m=grid[0].length;
        if(j-1>=0){
            int x=grid[i][j-1];
            if(x==1 ||x==4 || x==6)flag=fn(i,j-1,grid,vis);
        }
        if(i+1<n){
            int x=grid[i+1][j];
            if(x==2 || x==5 || x==6)flag|=fn(i+1,j,grid,vis);
        }
        return flag;
    }
    public boolean street4(int i,int j,int[][] grid,boolean[][] vis){
        boolean flag=false;
        int n=grid.length;
        int m=grid[0].length;
        if(j+1<m){
            int x=grid[i][j+1];
            if(x==1||x==3||x==5)flag=fn(i,j+1,grid,vis);
        }
        if(i+1<n){
            int x=grid[i+1][j];
            if(x==2||x==5||x==6) flag|=fn(i+1,j,grid,vis);
        }
        return flag;
    }
    public boolean street5(int i,int j,int[][] grid,boolean[][] vis){
        boolean flag=false;
        int n=grid.length;
        int m=grid[0].length;
        if(j-1>=0){
            int x=grid[i][j-1];
            if(x==1||x==4||x==6)flag|=fn(i,j-1,grid,vis);
        }
        if(i-1>=0){
            int x=grid[i-1][j];
            if(x==2||x==3||x==4)flag|=fn(i-1,j,grid,vis);
        }
        return flag;
    }
    public boolean street6(int i,int j,int[][] grid,boolean[][] vis){
        boolean flag=false;
        int n=grid.length;
        int m=grid[0].length;
        if(j+1<m){
            int x=grid[i][j+1];
            if(x==1||x==3||x==5)flag|=fn(i,j+1,grid,vis);
        }
        if(i-1>=0){
            int x=grid[i-1][j];
            if(x==2||x==3||x==4)flag|=fn(i-1,j,grid,vis);
        }
        return flag;
    }
}
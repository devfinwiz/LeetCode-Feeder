class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans=0;
        for(int i=0;i<points.length-1;i++){
            int x = points[i][0];
            int y=points[i][1];
            int X=points[i+1][0];
            int Y=points[i+1][1];
            ans+=Math.max(Math.abs(X-x),Math.abs(Y-y));
        }
        return ans;
    }
}
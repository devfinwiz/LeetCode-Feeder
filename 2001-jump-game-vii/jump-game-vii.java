class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        boolean[] visited=new boolean[n];
        visited[0]=true;
        int farthest=0;
        for (int i=0;i<n;i++){
            if (!visited[i]) continue;
            int start=Math.max(i+minJump,farthest+1);
            int end=Math.min(i+maxJump,n-1);
            for (int j = end; j >= start; j--){
                if(s.charAt(j)=='0'){
                    visited[j]=true;
                }
            }
            farthest=end;
            if(visited[n-1])return true;
        }
        return visited[n-1];
    }
}
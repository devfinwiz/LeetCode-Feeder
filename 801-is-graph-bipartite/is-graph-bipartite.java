class Solution {
    public boolean bfs(int[][]graph,int[] team,int start){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int node=q.poll();
            for(int neigh:graph[node]){
                if(team[neigh]==0){
                    team[neigh]=3-team[node];
                    q.offer(neigh);
                }
                else if(team[neigh]==team[node])return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length-1;
        int[] team=new int[graph.length];
        for(int i=0;i<n;i++){
            if(team[i]==0){
                if(!bfs(graph,team,i))return false;
            }
        }
        return true;
    }
}
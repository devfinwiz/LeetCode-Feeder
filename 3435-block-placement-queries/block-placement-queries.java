class Solution {
    static int dist[];
    static int ans[];
    static ArrayList<Integer> obstacle;
    static void buildTree(int l, int r, int idx){
        if(l==r){
            ans[idx] = dist[l];
            return;
        }
        int mid = l+(r-l)/2;
        buildTree(l,mid,2*idx+1);
        buildTree(mid+1,r,2*idx+2);
        ans[idx] = Math.max(ans[2*idx+1],ans[2*idx+2]);
    }
    static int findMax(int l, int r, int left, int right, int idx){
        if(r<left || l>right) return Integer.MIN_VALUE;
        if(l>=left && r<=right) return ans[idx];
        int mid = l+(r-l)/2;
        int a = findMax(l,mid,left,right,2*idx+1);
        int b = findMax(mid+1,r,left,right,2*idx+2);
        return Math.max(a,b);
    }
    static void update(int l, int r, int idx, int pos, int val){
        if(l==r){
            ans[idx] = val;
            return;
        }
        int mid = l+(r-l)/2;
        if(pos<=mid) update(l,mid,2*idx+1,pos,val);
        else update(mid+1,r,2*idx+2,pos,val);
        ans[idx] = Math.max(ans[2*idx+1],ans[2*idx+2]);
    }
    public static int findNext(int x) {
        int left = 0;
        int right = obstacle.size() - 1;
        int result = -1; 
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (obstacle.get(mid) > x) {
                result = mid; 
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        return result;
    }
    public static int findPrev(int x) {
        int left = 0;
        int right = obstacle.size() - 1;
        int result = -1; 
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (obstacle.get(mid) < x) {
                result = mid;
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return result;
    }
    public static List<Boolean> getResults(int[][] q){
        int n = Math.min(50004,3*q.length)+5;
        dist = new int[n];
        ans = new int[4*n];
        obstacle = new ArrayList<>();
        obstacle.add(0);
        obstacle.add(n-1);
        List<Boolean> a = new ArrayList<>();
        dist[n-1] = n-1;
        buildTree(0,n-1,0);
        boolean flag = true;
        for(int i=0; i<q.length; i++){
            int type = q[i][0];
            int x = q[i][1];
            if(type==1){
                flag = false;
                int nx = findNext(x);
                int pr = findPrev(x);
                int next = obstacle.get(nx);
                int prev = obstacle.get(pr);
                obstacle.add(nx,x);
                dist[x] = x-prev;
                update(0,n-1,0,x,x-prev);
                dist[next] = next-x;
                update(0,n-1,0,next,next-x);
            }else{
                int sz = q[i][2];
                int prev = findPrev(x);
                int max = findMax(0,n-1,0,obstacle.get(prev),0);
                max = Math.max(max,x-obstacle.get(prev));
                if(flag) max = x-obstacle.get(prev);
                if(sz<=max) a.add(true);
                else a.add(false);
            }
        }
        return a;
    }
}
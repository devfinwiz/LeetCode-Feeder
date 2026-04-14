class Solution {
    public long dp(int ind1,int ind2,List<Integer> robot,List<Integer> lst,long[][] memo){
        if(ind1==robot.size())return  0;
        if(ind2==lst.size())return (long)(1e12);
        if(memo[ind1][ind2]!=-1){
            return memo[ind1][ind2];
        }
        long take=Math.abs(robot.get(ind1)-lst.get(ind2))+dp(ind1+1,ind2+1,robot,lst,memo);
        long notTake=dp(ind1,ind2+1,robot,lst,memo);
        memo[ind1][ind2]=Math.min(take,notTake);
        return memo[ind1][ind2];
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->Integer.compare(a[0],b[0]));
        List<Integer> lst=new ArrayList<>();
        for(int[] fact:factory){
            for(int i=0;i<fact[1];i++){
                lst.add(fact[0]);
            }
        }
        int rCnt=robot.size();
        int factCnt=lst.size();
        long[][] memo=new long[rCnt][factCnt];
        for(long[] row:memo){
            Arrays.fill(row,-1);
        }
        return dp(0,0,robot,lst,memo);
    }
}
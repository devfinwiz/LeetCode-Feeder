class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashMap<String,Integer> pMap=new HashMap<>();
        HashMap<String,Integer> nMap=new HashMap<>();
        for(String feed:positive_feedback){
            pMap.put(feed,pMap.getOrDefault(feed,0)+1);
        }
        for(String feed:negative_feedback){
            nMap.put(feed,nMap.getOrDefault(feed,0)+1);
        }
        int[][] ans=new int[report.length][2];
        int i=0;
        for(String s:report){
            String[] splitt=s.split(" ");
            int cnt=0;
            for(String spli:splitt){
                if(pMap.containsKey(spli)) cnt+=3;
                else if(nMap.containsKey(spli)) cnt-=1;
            }
            ans[i][0]=student_id[i];
            ans[i][1]=cnt;
            i+=1;
        }
        Arrays.sort(ans, (a, b) -> {
            if (b[1] == a[1]) return a[0] - b[0];
            return b[1] - a[1];
        });
        List<Integer> finalAns=new ArrayList<>();
        for(int j=0;j<k;j++){
            finalAns.add(ans[j][0]);
        }   
        return finalAns;
    }
}
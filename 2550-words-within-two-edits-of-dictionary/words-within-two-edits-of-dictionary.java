class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            for(String s:dictionary){
                String query=queries[i];
                int dist=0;
                for(int j=0;j<s.length();j++){
                    if(query.charAt(j)!=s.charAt(j)){
                        dist++;
                    }
                }
                if(dist<=2){
                    ans.add(query);
                    break;
                }
            }
            
        }
        return ans;
    }
}
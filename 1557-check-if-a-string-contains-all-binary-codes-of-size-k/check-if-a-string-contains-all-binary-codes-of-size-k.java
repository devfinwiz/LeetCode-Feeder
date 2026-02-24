class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        int i=0;
        int j=k;
        while(j<=s.length()){
            String sub=s.substring(i,j);
            map.put(sub,map.getOrDefault(sub,0)+1);
            if(map.size()==(int)Math.pow(2,k))break;
            i++;
            j++;
        }
        return map.size()==(int)Math.pow(2,k);
    }
}
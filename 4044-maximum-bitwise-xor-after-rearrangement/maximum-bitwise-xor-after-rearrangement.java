class Solution {
    public String maximumXor(String s, String t) {
        HashMap<Integer,Integer> mapS=new HashMap<>();
        HashMap<Integer,Integer> mapT=new HashMap<>();
        for(char ch:s.toCharArray()){
            mapS.put(ch-'0',mapS.getOrDefault(ch-'0',0)+1);
        }
        for(char ch:t.toCharArray()){
            mapT.put(ch-'0',mapT.getOrDefault(ch-'0',0)+1);
        }
        mapS.putIfAbsent(1,0);
        mapS.putIfAbsent(0,0);
        mapT.putIfAbsent(1,0);
        mapT.putIfAbsent(0,0);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int cs=s.charAt(i)-'0';
            int ct=t.charAt(i)-'0';
            int diff=1-cs;
            if(mapT.get(diff)>0){
                sb.append('1');
                mapT.put(diff,mapT.get(diff)-1);
                mapS.put(cs,mapS.get(cs)-1);
            }
            else{
                sb.append('0');
                mapS.put(cs,mapS.get(cs)-1);
                mapT.put(cs,mapT.get(cs)-1);
            }
        }
        
        return sb.toString();
    }
}
class Solution {
    public String backTrack(Map<String,Integer> map, StringBuilder sb, String str,int n){
        if(sb.length()== n){
            String finalStr = sb.toString();
            if(!map.containsKey(finalStr)){
                return finalStr;
            }
            return null;
        }
        sb.append('0');
        String res = backTrack(map,sb,str,n);
        if(res!=null) return res;
        sb.deleteCharAt(sb.length()-1);
        sb.append('1');
        res =  backTrack(map,sb,str,n);
        if(res != null) return res;
        sb.deleteCharAt(sb.length()-1);
        return null;
    }
    public String findDifferentBinaryString(String[] nums) {
        Map<String,Integer> map = new HashMap<>();
        for(String str:nums){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        String str = "";
        return backTrack(map,sb,str,nums.length);
    }
}
class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            if(word.length() >= k){
                String prefix = word.substring(0, k);
                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }
        }
        int cnt = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > 1) cnt++;
        }
        return cnt;
    }
}

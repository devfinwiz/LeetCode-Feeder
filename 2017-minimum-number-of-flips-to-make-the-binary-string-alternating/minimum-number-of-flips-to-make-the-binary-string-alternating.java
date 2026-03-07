class Solution {
    public int minFlips(String s) {
        String alt = "01";
        int n = s.length();
        int cnt = 0;
        for(int i = 0; i < n; ++i) {
            if(s.charAt(i) != alt.charAt(i & 1)) cnt++;
        }
        int flips = Math.min(cnt, n - cnt);
        for(int i = 0; i < n; ++i){
            if(s.charAt(i) != alt.charAt(i & 1)) {
                --cnt;
            }
            if(s.charAt(i) != alt.charAt((i + n) & 1)){
                ++cnt;
            }    
            flips = Math.min(flips, Math.min(cnt, n - cnt));
        }
        return flips;
    }
}
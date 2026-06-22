class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] alph=new int[26];
        for(char ch:text.toCharArray()){
            alph[ch-'a']++;
        }
        int cnt=Integer.MAX_VALUE;
        cnt=Math.min(cnt,alph['b'-'a']);
        cnt=Math.min(cnt,alph['a'-'a']);
        cnt=Math.min(cnt,alph['l'-'a']/2);
        cnt=Math.min(cnt,alph['o'-'a']/2);
        cnt=Math.min(cnt,alph['n'-'a']);
        return cnt;
    }
}
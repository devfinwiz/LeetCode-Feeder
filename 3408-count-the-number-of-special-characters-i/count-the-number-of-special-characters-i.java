class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] smaller=new boolean[26];
        boolean[] capital=new boolean[26];
        for(char ch:word.toCharArray()){
            if(Character.isLowerCase(ch)){
                smaller[ch-'a']=true;
            }
        }
        for(char ch:word.toCharArray()){
            if(Character.isUpperCase(ch)){
                capital[ch-'A']=true;
            }
        }
        int cnt=0;
        for(int i=0;i<26;i++){
            if(smaller[i]&&capital[i])cnt++;
        }
        return cnt;
    }
}
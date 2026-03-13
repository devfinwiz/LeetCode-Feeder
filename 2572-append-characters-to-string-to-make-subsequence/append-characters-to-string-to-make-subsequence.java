class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i+=1;
                j+=1;
            }
            else{
                i+=1;
            }
        }
        if(j>=t.length())return 0;
        return t.length()-j;
    }
}
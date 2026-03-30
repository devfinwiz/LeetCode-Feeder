class Solution {
    public int firstMatchingIndex(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==s.charAt(s.length()-i-1))return i;
        }
        return -1;
    }
}
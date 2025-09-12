class Solution {
    public boolean isVowel(char ch){
        char chh = Character.toLowerCase(ch);
        return (chh == 'a' || chh == 'e' || chh == 'i' || chh == 'o' || chh == 'u');
    }
    public boolean doesAliceWin(String s) {
        int vowel = 0;
        for(char ch:s.toCharArray()){
            if(isVowel(ch)) vowel++;
        }
        if(vowel == 0) return false;
        return true;
    }
}
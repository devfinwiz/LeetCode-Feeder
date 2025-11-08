class Solution {
    public boolean isVowelChar(char ch) {
        ch = Character.toLowerCase(ch);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
    public boolean isVowel(String word) {
        if (word == null || word.isEmpty()) return false;
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowelChar(first) && isVowelChar(last);
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int ind = 0;
        int n = words.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (isVowel(words[i]) ? 1 : 0);
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l < 0) l = 0;
            if (r >= prefix.length - 1) r = prefix.length - 2;
            if (l > r) { 
                ans[i] = 0; 
                continue; 
            }
            ans[i] = prefix[r+1] - prefix[l];
        }
        return ans;
    }
}
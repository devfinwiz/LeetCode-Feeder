class Solution {
    public boolean isVowel(char ch){
        char chh = Character.toLowerCase(ch);
        return (chh == 'a' || chh == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
    public int maxFreqSum(String s) {
        TreeMap<Character, Integer> conso = new TreeMap<>();
        TreeMap<Character,Integer> vowels = new TreeMap<>();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.put(ch, vowels.getOrDefault(ch, 0) + 1);
            } else {
                conso.put(ch, conso.getOrDefault(ch, 0) + 1);
            }
        }

        int maxVowel = vowels.values().stream().max(Integer::compareTo).orElse(0);
        int maxConso = conso.values().stream().max(Integer::compareTo).orElse(0);

        return maxVowel + maxConso;
        
    }
}
class Solution {
    public boolean isVowel(char ch){
            ch = Character.toLowerCase(ch);
            return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public String sortVowels(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                arr.add(ch);
            }
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i=0;i<s.length();i++){
            if(!isVowel(s.charAt(i))){
                sb.append(s.charAt(i));
            }
            else{
                sb.append(arr.get(index++));
            }
        }
        return sb.toString();
    }
}
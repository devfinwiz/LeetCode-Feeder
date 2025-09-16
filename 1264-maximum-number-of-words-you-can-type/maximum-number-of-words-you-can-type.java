class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:brokenLetters.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        String[] arr = text.split(" ");
        int count = 0;
        for(String s:arr){
            int len = s.length();
            boolean wrong = false;
            for(int i=0;i<len;i++){
                if(map.containsKey(s.charAt(i))){
                    wrong = true;
                }
            }
            if(!wrong) count++;
        }
        return count;
    }
}
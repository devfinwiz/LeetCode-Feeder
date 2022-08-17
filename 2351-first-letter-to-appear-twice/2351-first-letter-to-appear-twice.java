class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character,Integer> m= new HashMap<Character,Integer>();
        char c=' ';
        for(int i=0;i<s.length();i++){
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
            if(m.get(s.charAt(i))==2){
                c=s.charAt(i);
                break;
            }
            
        }
        return c;
    }
}
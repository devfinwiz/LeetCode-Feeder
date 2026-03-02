class Solution {
    public String mergeCharacters(String s, int k) {
        Stack<Character> st=new Stack<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                int first=map.get(ch);
                if(st.size()-1-first<=k){
                    continue;
                }
            }
                map.put(ch,st.size()-1);
                st.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
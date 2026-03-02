class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder sb=new StringBuilder();
        boolean conso=false;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if((ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')){
                if(!conso)continue;
                else sb.append(ch);
            }
            else{
                conso=true;
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}
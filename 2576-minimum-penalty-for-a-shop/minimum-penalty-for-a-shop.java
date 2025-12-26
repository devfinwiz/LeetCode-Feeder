class Solution {
    public int bestClosingTime(String customers) {
        int y=0;
        for(char ch:customers.toCharArray()){
            if(ch == 'Y') y++;
        }
        int minn = y;
        int before=0;
        for(int i=0;i<customers.length();i++){
            char ch = customers.charAt(i);
            if(ch == 'Y') y--;
            else y++;
            if(y < minn){
                before=i+1;
                minn = y;
            }
        }
        return before;
    }
}
class Solution {
    public int minDeletionSize(String[] strs) {
        int len=strs[0].length();
        int count=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<strs.length-1;j++){
                if(strs[j].charAt(i) <= strs[j+1].charAt(i)){
                    continue;
                }
                else{
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
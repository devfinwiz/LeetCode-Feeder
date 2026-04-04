class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows==0) return "";
        int len=encodedText.length();
        int col=len/rows;
        StringBuilder sb=new StringBuilder();
        for(int ind=0;ind<col;ind++){
            int i=0;
            int j=ind;
            while(i<rows && j<col){
                sb.append(encodedText.charAt(i*col+j));
                i++;
                j++;
            }
        }
        int end=sb.length()-1;
        while(end>=0 && sb.charAt(end)==' ') end--;
        return sb.substring(0,end+1);
    }
}
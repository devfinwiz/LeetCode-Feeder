class Solution {
    char[] arr= {'a','b','c'};
    public void backTrack(StringBuilder sb,int n,ArrayList<String> lst){
        if(sb.length()==n){
            lst.add(sb.toString());
            return;
        }
        for(int i=0;i<3;i++){
            if(sb.length()==0){
                sb.append(arr[i]);
                backTrack(sb,n,lst);
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                if(sb.charAt(sb.length()-1)!=arr[i]){
                    sb.append(arr[i]);
                    backTrack(sb,n,lst);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
    public String getHappyString(int n, int k) {
        StringBuilder sb=new StringBuilder();
        ArrayList<String> lst=new ArrayList<>();
        backTrack(sb,n,lst);
        if(k>lst.size())return "";
        return lst.get(k-1);
    }
}
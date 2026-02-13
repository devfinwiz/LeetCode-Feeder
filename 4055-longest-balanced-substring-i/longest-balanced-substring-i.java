class Solution {
    public int longestBalanced(String str) {
        int n=str.length();
        int ans=0;
        int[] arr=new int[26];
        for (int i=0;i<n;i++){
            Arrays.fill(arr,0);
            for (int j=i;j<n;j++){
                boolean ok=true;
                int idx=str.charAt(j)-'a';
                arr[idx]++;
                for(int val:arr){
                    if(val>0&&val!=arr[idx]){
                        ok=false;
                        break;
                    }
                }
                if(ok){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}

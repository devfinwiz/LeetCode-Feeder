class Solution{
    public String findTheString(int[][] arr){
        int n=arr.length;
        int[] a=new int[n];
        a[0]=0;
        for(int i=1;i<n;i++){
            int mask=0,take=-1;
            for(int j=0;j<i;j++){
                if(arr[i][j]>0){
                    take=a[j];
                    break;
                }
                else if(arr[i][j]==0){
                    mask|=1<<a[j];
                }
            }
            if(take!=-1){
                a[i]=take;
            }
            else{
                int ch=0;
                while(ch<26 && ((mask>>ch)&1)==1) ch++;
                if(ch>=26) return "";
                a[i]=ch;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(a[i]!=a[j]){
                    if(arr[i][j]!=0) return "";
                }
                else{
                    if(i==n-1 || j==n-1){
                        if(arr[i][j]!=1) return "";
                    }
                    else{
                        if(arr[i][j]!=arr[i+1][j+1]+1) return "";
                    }
                }
            }
        }
        char[] res=new char[n];
        for(int i=0;i<n;i++){
            res[i]=(char)('a'+a[i]);
        }
        return new String(res);
    }
}
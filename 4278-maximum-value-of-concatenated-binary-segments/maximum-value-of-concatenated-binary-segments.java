class Solution {
    public int get(int a,int b,int c,int d,int ind){
        int ab=a+b;
        if(ind<ab){
            return ind<a?1:0;
        }
        else{
            ind-=ab;
            return ind<c?1:0;
        }
    }
    public int maxValue(int[] nums1, int[] nums0) {
        int MOD=1_000_000_007;
        int[][] arr=new int[nums1.length][2];
        for(int i=0;i<nums1.length;i++){
            arr[i][0]=nums1[i];
            arr[i][1]=nums0[i];
        }
        Arrays.sort(arr,(a,b)->{
            int a1=a[0];
            int a0=a[1];
            int b1=b[0];
            int b0=b[1];
            int la=a1+a0;
            int lb=b1+b0;
            int total=la+lb;
            int i=0;
            int j=0;
            while(i<total&&j<total){
                int ba=get(a1,a0,b1,b0,i);
                int bb=get(b1,b0,a1,a0,j);
                if(ba!=bb){
                    return bb-ba;
                }
                i++;
                j++;
            }
            return 0;
        });
        long res=0;
        for(int [] ar:arr){
            int o=ar[0];
            int z=ar[1];
            for(int i=0;i<o;i++){
                res=(res*2+1)%MOD;
            }
            for(int i=0;i<z;i++){
                res=(res*2)%MOD;
            }
        }
        return (int)res;
    }
}
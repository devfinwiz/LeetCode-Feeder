class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[A.length];
        for(int i=0;i<A.length;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            map.put(B[i],map.getOrDefault(B[i],0)+1);
            ans[i]=2*(i+1)-map.size();
        }
        return ans;
    }
}
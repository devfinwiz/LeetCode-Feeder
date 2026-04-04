class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums2){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        long[] sqr=new long[nums1.length];
        for(int i=0;i<nums1.length;i++){
            sqr[i]=(long)nums1[i]*nums1[i];
        }
        int cnt=0;
        for(int i=0;i<sqr.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(sqr[i]%(long)nums2[j]==0){
                    int num=(int)(sqr[i]/(long)nums2[j]);
                    if(map.containsKey(num)){
                        if(num==nums2[j]){
                            int freq=map.get(num);
                            cnt+=freq-1;
                        }
                        else{
                            cnt+=map.get(num);
                        }
                    }
                }
            }
        }
        HashMap<Integer,Integer> map2=new HashMap<>();
        for(int num:nums1){
            map2.put(num,map2.getOrDefault(num,0)+1);
        }
        long[] sqr2=new long[nums2.length];
        for(int i=0;i<nums2.length;i++){
            sqr2[i]=(long)nums2[i]*nums2[i];
        }
        for(int i=0;i<sqr2.length;i++){
            for(int j=0;j<nums1.length;j++){
                if(sqr2[i]%(long)nums1[j]==0){
                    int num=(int)(sqr2[i]/(long)nums1[j]);
                    if(map2.containsKey(num)){
                        if(num==nums1[j]){
                            int freq=map2.get(num);
                            cnt+=freq-1;
                        }
                        else{
                            cnt+=map2.get(num);
                        }
                    }
                }
            }
        }
        return cnt/2;
    }
}
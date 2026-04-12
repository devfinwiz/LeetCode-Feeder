class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        int minDist=Integer.MAX_VALUE;
        for(ArrayList<Integer> list:map.values()) {
            int n=list.size();
            if(n>=3){
                for(int i=0;i<n;i++){
                    for(int j=i+1;j<n;j++){
                        for(int k=j+1;k<n;k++){
                            int a=list.get(i);
                            int b=list.get(j);
                            int c=list.get(k);
                            int dist=Math.abs(b-a)+Math.abs(c-a)+Math.abs(c-b);
                            minDist=Math.min(minDist,dist);
                        }
                    }
                }
            }
        }
        return minDist==Integer.MAX_VALUE?-1:minDist;
    }
}
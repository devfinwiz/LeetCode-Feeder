class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minu = new int[timePoints.size()];
        for(int i=0;i<timePoints.size();i++){
            String time = timePoints.get(i);
            int hour = Integer.parseInt(time.substring(0,2));
            int min = Integer.parseInt(time.substring(3));
            minu[i] = hour*60+min;
        }
        Arrays.sort(minu);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<minu.length- 1;i++){
            ans = Math.min(ans,minu[i+1]-minu[i]);
        }
        return Math.min(ans,24*60-minu[minu.length-1]+minu[0]);
    }
}
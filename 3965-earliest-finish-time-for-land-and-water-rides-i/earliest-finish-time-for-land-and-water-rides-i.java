class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int answer = 99999999;
        int t1;
        int t2;
        int min;
        for (int i = 0; i <  landStartTime.length; i ++ ) {  
            for (int j = 0; j < waterStartTime.length; j++) {
               t1 = Math.max(landStartTime[i] + landDuration[i] , waterStartTime[j]) + waterDuration[j];
               t2 = Math.max(waterStartTime[j] + waterDuration[j] , landStartTime[i]) + landDuration[i];
                min= Math.min(t1,t2);
                answer = Math.min(min,answer);
            }
        }
        return answer;
    }
}
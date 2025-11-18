class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer,Long> map = new HashMap<>();
        int i=0;
        long day = 1;
        while(i<tasks.length){
            int task = tasks[i];
            if(!map.containsKey(task)){
                map.put(task,day+space+1);
                i++;
            }
            else{
                long thres = map.get(task);
                if(thres > day){
                    day=thres;
                    continue;
                }
                else{
                    map.put(task,day+space+1);
                    i++;
                }
            }
            day++;
        }
        return day-1;
    }
}
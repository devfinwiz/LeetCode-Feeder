class EventManager {
    PriorityQueue<int[]> pq;
    HashMap<Integer,Integer> map;
    public EventManager(int[][] events) {
        map=new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return a[0] - b[0];
        });
        for(int[] event:events){
            int id=event[0];
            int vall=event[1];
            map.put(id,vall);
            pq.add(new int[]{id,vall});
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId,newPriority);
        pq.add(new int[]{eventId,newPriority});
    }
    
    public int pollHighest() {
        while(!pq.isEmpty()){
            int[] node=pq.poll();
            int id=node[0];
            int vall=node[1];
            if(map.get(id)!=null&&map.get(id)==vall){
                map.remove(id);
                return id;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */
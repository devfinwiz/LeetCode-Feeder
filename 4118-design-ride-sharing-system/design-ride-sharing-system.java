class RideSharingSystem {
    public Deque<Integer> rider=new LinkedList<>();
    public Deque<Integer> driver=new LinkedList<>();
    public HashMap<Integer,Integer> riderMap=new HashMap<>();
    public HashMap<Integer,Integer> driverMap=new HashMap<>();
    public RideSharingSystem() {
    }
    public void addRider(int riderId) {
        rider.add(riderId);
        riderMap.put(riderId,1);
    }
    public void addDriver(int driverId) {
        driver.add(driverId);
        driverMap.put(driverId,1);
    }
    public int[] matchDriverWithRider() {
        int[] match=new int[2];
        if(!rider.isEmpty()&&!driver.isEmpty()){
            match[0]=driver.pollFirst();
            match[1]=rider.pollFirst();
        }
        else{
            match[0]=-1;
            match[1]=-1;
        }
        return match;
    }
    public void cancelRider(int riderId) {
        if(riderMap.containsKey(riderId)){
            rider.remove(Integer.valueOf(riderId));
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */
class Solution {
    public double angleClock(int hour, int minutes) {
        double hangle=30.0*hour+0.5*minutes;
        double minangle=6.0*minutes;
        double diff=Math.abs(hangle-minangle);
        return Math.min(diff,360-diff);
    }
}
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String second=s+s;
        return second.contains(goal);
    }
}
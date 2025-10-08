
class Solution {
    public int bs(int spell, int[] potions, int low, int high, long success){
        int power = 0;
        while(low <= high){
            int mid = (low) + (high-low)/2;
            if((long)spell * potions[mid] >= success){
                power += (high - mid + 1);
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }
        return power;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        int ind = 0;
        for(int spell:spells){
            ans[ind++] = bs(spell, potions, 0, m-1, success);
        }
        return ans;
        
    }
}
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int i=0;
        int len=deck.length;
        int j=0;
        int[] result=new int[deck.length];
        boolean skip=false;
        while(i<deck.length){
            if(result[j]==0){
                if(!skip){
                    result[j]=deck[i];
                    i++;
                }
                skip=!skip;
            }
            j=(j+1)%len;
        }
        return result;
    }
}
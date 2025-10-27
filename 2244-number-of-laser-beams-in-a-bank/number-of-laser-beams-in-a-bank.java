class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int curr = 0;
        int ans = 0;
        for(int i=0;i<bank.length;i++){
            if(prev == 0){
                for(int j=0;j<bank[i].length();j++){
                    if(bank[i].charAt(j) == '1'){
                        prev++;
                    }
                }
            }
            else{
                for(int j=0;j<bank[i].length();j++){
                    if(bank[i].charAt(j) == '1'){
                        curr++;
                    }
                }    
            }
            if(curr > 0){
                ans = ans + (prev*curr);
                prev = curr;
                curr = 0;
            }
        }
        return ans;
    }
}
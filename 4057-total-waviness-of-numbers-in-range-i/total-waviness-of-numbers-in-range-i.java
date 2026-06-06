class Solution {
    public int waviness(int num){
        if(num < 100) return 0;
        int next = 0;
        int prev = num%10;
        num /= 10;
        int curr = num%10;
        num /= 10;
        int count = 0;
        while(num > 0){
            next = num%10;
            num /= 10;
            if((curr > next && curr > prev) || (curr < next && curr < prev)) count++;
            prev = curr;
            curr = next;
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        if(num2 < 100) return 0;
        int count = 0;
        for(int i = num1 ; i <= num2 ; i++){
            count += waviness(i);
        }
        return count;
    }
}
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int index = happiness.length - 1;
        int dec = 0;
        while (k-- > 0 && index >= 0) {
            int curr = happiness[index] - dec;
            if (curr <= 0) break;

            sum += curr;
            dec++;
            index--;
        }
        return sum;
    }
}

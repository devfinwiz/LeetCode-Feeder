class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int pile : piles) {
            pq.offer(pile);
        }
        while (k-- > 0) {
            int largest = pq.poll();
            int reduced = largest - largest / 2;
            pq.offer(reduced);
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}

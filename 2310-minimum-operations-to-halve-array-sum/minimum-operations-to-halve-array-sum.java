import java.util.*;

class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double totalSum = 0;
        for (int num : nums) {
            totalSum += num;
            pq.offer((double) num);
        }
        double target = totalSum / 2.0;
        double currentSum = totalSum;
        int operations = 0;
        while (currentSum > target) {
            double largest = pq.poll();  
            double half = largest / 2.0; 
            currentSum -= half;          
            pq.offer(half);              
            operations++;
        }

        return operations;
    }
}

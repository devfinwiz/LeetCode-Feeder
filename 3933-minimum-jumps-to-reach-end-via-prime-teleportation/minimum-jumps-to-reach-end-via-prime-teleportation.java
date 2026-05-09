class Solution {
    public int minJumps(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int maxValue = 0;
        int jump = 0;
        Map<Integer, List<Integer>> map =new HashMap<>(); 
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, nums[i]);
        }
        int[] prime = new int[maxValue+1];
        findPrime(maxValue, prime);
        for(int i = 0; i < n; i++) { 
            List<Integer> primefactors = findFactors(nums[i], prime); 
            for(int factor : primefactors) {
                map.putIfAbsent(factor, new ArrayList<>());
                map.get(factor).add(i);
            }
        }
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                if(cur == n-1) {
                    return jump;
                }
                if(cur + 1 < n && !visited[cur+1]) {
                    queue.offer(cur+1);
                    visited[cur+1] = true;
                }
                if(cur - 1 >= 0 && !visited[cur-1]) {
                    queue.offer(cur-1);
                    visited[cur-1] = true;
                }
                if(nums[cur] > 1 && prime[nums[cur]] == nums[cur] ) {
                    for(int index : map.getOrDefault(nums[cur], new ArrayList<>())) {
                        if(!visited[index]) {
                            queue.offer(index);
                            visited[index] = true;
                        }
                    }
                    map.remove(nums[cur]);
                }
            }
            jump++;
        }
        return jump;
    }
    private void findPrime(int maxValue, int[] prime) {
        for(int i = 0; i <= maxValue; i++) {
            prime[i] = i;
        }
        for(int i = 2; i * i <= maxValue; i++) {
            if(prime[i] == i) {
                for(int j = i * i; j <= maxValue; j += i) { 
                    if(prime[j] == j) {
                        prime[j] = i; 
                    }
                }
            }
        }
    }
    private List<Integer> findFactors(int value, int[] prime) { 
        List<Integer> factors = new ArrayList<>();
        while(value > 1) {
            int factor = prime[value];
            factors.add(factor);
            while(value % factor == 0) {
                value = value / factor;
            }
        }
        return factors;
    }
}
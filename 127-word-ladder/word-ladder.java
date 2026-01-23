class Solution {
    class Pair {
        String word;
        int step;
        public Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String w : wordList) {
            set.add(w);
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.word;
            int step = curr.step;
            if (word.equals(endWord)) {
                return step;
            }
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.offer(new Pair(newWord, step + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}

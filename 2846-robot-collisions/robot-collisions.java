class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new int[]{positions[i], healths[i]});
        }
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> positions[a] - positions[b]);
        Stack<Integer> st = new Stack<>();
        st.push(order[0]);
        for (int k = 1; k < n; k++) {
            int ind = order[k];
            if (!st.isEmpty() && directions.charAt(st.peek()) == 'R' && directions.charAt(ind) == 'L') {
                while (!st.isEmpty() && directions.charAt(st.peek()) == 'R') {
                    int prev = st.peek();
                    if (!map.containsKey(prev) || !map.containsKey(ind)) break;
                    int[] arr1 = map.get(prev);
                    int[] arr2 = map.get(ind);

                    if (arr1[1] > arr2[1]) {
                        map.put(prev, new int[]{arr1[0], arr1[1] - 1});
                        map.remove(ind);
                        break;
                    } else if (arr1[1] < arr2[1]) {
                        map.put(ind, new int[]{arr2[0], arr2[1] - 1});
                        map.remove(prev);
                        st.pop();
                    } else {
                        map.remove(prev);
                        map.remove(ind);
                        st.pop();
                        break;
                    }
                }
                if (map.containsKey(ind)) st.push(ind);
            } else {
                st.push(ind);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(i)) ans.add(map.get(i)[1]);
        }
        return ans;
    }
}
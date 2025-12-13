import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);
        List<String[]> valid = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (code[i] == null || !code[i].matches("^[a-zA-Z0-9_]+$")) {
                continue;
            }
            if (!priority.containsKey(businessLine[i])) {
                continue;
            }
            if (!isActive[i]) {
                continue;
            }
            valid.add(new String[]{businessLine[i], code[i]});
        }
        Collections.sort(valid, (a, b) -> {
            int p1 = priority.get(a[0]);
            int p2 = priority.get(b[0]);
            if (p1 != p2) {
                return p1 - p2;
            }
            return a[1].compareTo(b[1]);
        });
        List<String> result = new ArrayList<>();
        for (String[] v : valid) {
            result.add(v[1]);
        }
        return result;
    }
}

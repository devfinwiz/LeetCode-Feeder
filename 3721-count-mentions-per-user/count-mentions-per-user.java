class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) {
                return Integer.compare(timeA, timeB);
            }
            boolean aIsMessage = a.get(0).equals("MESSAGE");
            boolean bIsMessage = b.get(0).equals("MESSAGE");
            return Boolean.compare(aIsMessage, bIsMessage);
        });
        int[] count = new int[numberOfUsers];
        int[] nextOnlineTime = new int[numberOfUsers];
        for (List<String> event : events) {
            int curTime = Integer.parseInt(event.get(1));
            String type = event.get(0);
            if (type.equals("MESSAGE")) {
                String target = event.get(2);
                if (target.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        count[i]++;
                    }
                } 
                else if (target.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (nextOnlineTime[i] <= curTime) {
                            count[i]++;
                        }
                    }
                }
                 else {
                    String[] users = target.split(" ");
                    for (String user : users) {
                        int idx = Integer.parseInt(user.substring(2));
                        count[idx]++;
                    }
                }
            } 
            else {
                int idx = Integer.parseInt(event.get(2));
                nextOnlineTime[idx] = curTime + 60;
            }
        }

        return count;
    }
}
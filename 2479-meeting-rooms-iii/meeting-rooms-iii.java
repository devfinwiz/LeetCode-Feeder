class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] roomFreeTime = new long[n];
        int[] roomMeetingCounter = new int[n];
        Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[0], m2[0]));
        for (int[] currentMeeting : meetings) {
            int meetingStartTime = currentMeeting[0];
            int meetingEndTime = currentMeeting[1];
            long earliestRoomFreeTime = Long.MAX_VALUE;
            int earliestFreeRoomIndex = 0;
            boolean roomAssigned = false;
            for (int roomIndex = 0; roomIndex < n; roomIndex++) {
                if (roomFreeTime[roomIndex] <= meetingStartTime) {
                    roomAssigned = true;
                    roomMeetingCounter[roomIndex]++;
                    roomFreeTime[roomIndex] = meetingEndTime;
                    break;
                }
                if (roomFreeTime[roomIndex] < earliestRoomFreeTime) {
                    earliestRoomFreeTime = roomFreeTime[roomIndex];
                    earliestFreeRoomIndex = roomIndex;
                }
            }
            if (!roomAssigned) {
                roomFreeTime[earliestFreeRoomIndex] += 
                        (meetingEndTime - meetingStartTime);
                roomMeetingCounter[earliestFreeRoomIndex]++;
            }
        }
        int maxMeetingsHeld = 0;
        int mostUsedRoomIndex = 0;
        for (int roomIndex = 0; roomIndex < n; roomIndex++) {
            if (roomMeetingCounter[roomIndex] > maxMeetingsHeld) {
                maxMeetingsHeld = roomMeetingCounter[roomIndex];
                mostUsedRoomIndex = roomIndex;
            }
        }
        return mostUsedRoomIndex;
    }
}

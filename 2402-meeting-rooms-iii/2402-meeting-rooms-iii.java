class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] alvTime = new long[n];
        int[] meetCount = new int[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            long minTime = Long.MAX_VALUE;
            int minRoomIfnonIsFound = 0;
            boolean foundRoom = false;

            for (int i = 0; i < n; i++) {
                if (alvTime[i] <= start) {
                    foundRoom = true;
                    meetCount[i]++;
                    alvTime[i] = end;
                    break;
                }

                if (minTime > alvTime[i]) {
                    minTime = alvTime[i];
                    minRoomIfnonIsFound = i;
                }
            }

            if (!foundRoom) {
                alvTime[minRoomIfnonIsFound] += end - start;
                meetCount[minRoomIfnonIsFound]++;
            }
        }

        int maxMeet = 0;
        int maxMeetRoom = 0;
        for (int i = 0; i < n; i++) {
            if (maxMeet < meetCount[i]) {
                maxMeet = meetCount[i];
                maxMeetRoom = i;
            }
        }

        return maxMeetRoom;
    }
}
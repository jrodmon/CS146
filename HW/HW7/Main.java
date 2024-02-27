import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int[][] intervals = {{0,30}, {5,10}, {15,20}, {7,25}};
        int[][] intervals = {{0,50}, {5,10}, {25,35}, {30,35}};
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(int[][] intervals) {
        int minRooms = 0;
        int endPointer = 0;

        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        for (int i = 0; i < startTimes.length; i++){
            if(startTimes[i] < endTimes[endPointer]) {
                minRooms++;
            }
            else {
                endPointer++;
            }
        }
        return minRooms;
    }
}

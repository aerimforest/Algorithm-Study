import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        ArrayList<Job> arr = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            arr.add(new Job(jobs[i][0], jobs[i][1]));
        }
        Collections.sort(arr);
        int ans = 0;
        for (Job j: arr) {
            ans += (ans - j.start) + j.time;
        }
        System.out.println(ans / 3);
    }

    static class Job implements Comparable<Job>{
        int start, time;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Job o) {
            if (this.start != o.start) {
                return this.start - o.start;
            } else {
                return this.time - o.time;
            }
        }
    }
}

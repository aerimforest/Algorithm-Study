import java.io.*;
import java.util.*;

public class 강의실 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int N = Integer.valueOf(br.readLine());
        List<Lecture> lectures = new ArrayList<>();
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(str.nextToken());
            int s = Integer.valueOf(str.nextToken());
            int e = Integer.valueOf(str.nextToken());
            lectures.add(new Lecture(s,e));
        }

        Collections.sort(lectures);

        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Lecture l : lectures){
            while(!pq.isEmpty() && l.start >= pq.peek()){
                pq.poll();
            }

            pq.add(l.end);
            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }

    public static class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o){
            return start - o.start;
        }
    }
}

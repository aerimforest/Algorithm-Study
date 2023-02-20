import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, k, w;
    static int[] c;
    static long[] time;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // number of testcase
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            time = new long[n+1]; // a번째 건물을 짓는 데 필요한 시간
            c = new int[n+1]; // a번째 건물을 짓는 데 필요한 건물 개수
            adj = new ArrayList[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Long.parseLong(st.nextToken());
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                c[b]++;
            }
            w = Integer.parseInt(br.readLine());
            // end of input
            pro();
        } // end of testcase
        System.out.print(sb.toString());
    }

    static class Building implements Comparable<Building>{
        int num;
        long t;

        public Building(int num, long t) {
            this.num = num;
            this.t = t;
        }

        @Override
        public int compareTo(Building o) {
            // 시간으로 오름차순 정렬
            return Long.compare(this.t, o.t);

        }
    }

    static void pro() {
        PriorityQueue<Building> Q = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (c[i] == 0) Q.add(new Building(i, time[i]));
        }
        while (!Q.isEmpty()) {
            Building building = Q.poll(); // 건설 대기 목록에서 맨 앞에있는 것을 가져옴
            int x = building.num; // 건물 번호
            long t = building.t; // x번째 건물을 지은 시간
            if (x == w) { // 정답 건물을 지었으면
                sb.append(t).append("\n"); // 정답 추가
                return;
            }
            for (int y: adj[x]) { // 다음에 지을 건물 추가
                c[y]--; // y번째 건물을 짓기 위한 필요한 건물 개수 감소
                if (c[y] == 0) { // y번째 건물을 지을 수 있으면
                    Q.add(new Building(y, t + time[y])); // 대기 건설 목록에 추가
                }
            }
        }
    }
}

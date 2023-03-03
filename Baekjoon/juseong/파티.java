import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, X, M, ans;
    static ArrayList<Edge>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생의 수 (1 ≤ N ≤ 1,000)
        M = Integer.parseInt(st.nextToken()); // 단방향 도로의 개수 (1 ≤ M ≤ 10,000)
        X = Integer.parseInt(st.nextToken()); // 파티 도시의 번호
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[x].add(new Edge(y, w));
        }
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            int d1 = dijkstra(i, X); // 시작 마을에서 파티 마을 까지의 거리
            int d2 = dijkstra(X, i); // 파티 마을에서 시작 마을 까지의 거리
            ans = Math.max(ans, d1 + d2);
        }
        System.out.println(ans);
    }

    static int dijkstra(int start, int end) {
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0)); // 시작 마을 삽입
        dist[start] = 0; // 시작 마을의 거리는 0
        while(!pq.isEmpty()) {
            Edge cur = pq.poll(); // 현재 마을

            if (cur.to == end) break; // 도착 마을에 도착했으면

            for (Edge e: adj[cur.to]) {
                if (dist[cur.to] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[cur.to] + e.weight;
                    pq.add(new Edge(e.to, dist[e.to]));
                }
            }
        }
        return dist[end];
    }

    static class Edge implements Comparable<Edge> {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int V, E, K;
    static ArrayList<Edge>[] adj;
    static int[] dist;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        K = Integer.parseInt(br.readLine()); // 시작 정점
        adj = new ArrayList[V+1];
        dist = new int[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<Edge>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, w));
        }
        pq = new PriorityQueue<Edge>();
        dist[K] = 0;
        pq.add(new Edge(K, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            for (Edge e: adj[cur.to]) {
                if (dist[e.to] > dist[cur.to] + e.w) {
                    dist[e.to] = dist[cur.to] + e.w;
                    pq.add(new Edge(e.to, dist[e.to]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    static class Edge implements Comparable<Edge> {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}

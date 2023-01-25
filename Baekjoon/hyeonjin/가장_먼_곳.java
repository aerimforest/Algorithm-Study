import java.io.*;
import java.util.*;

public class 가장_먼_곳 {
    static int N;
    static int A;
    static int B;
    static int C;
    static int M;
    static List<Edge>[] edges;
    static int[][] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());

        edges = new List[N + 1];
        dist = new int[3][N + 1];

        for(int i = 1; i <= N; i++){
            edges[i] = new ArrayList<>();

            dist[0][i] = Integer.MAX_VALUE;
            dist[1][i] = Integer.MAX_VALUE;
            dist[2][i] = Integer.MAX_VALUE;
        }

        str = new StringTokenizer(br.readLine());
        A = Integer.valueOf(str.nextToken());
        B = Integer.valueOf(str.nextToken());
        C = Integer.valueOf(str.nextToken());

        M = Integer.valueOf(br.readLine());
        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int D = Integer.valueOf(str.nextToken());
            int E = Integer.valueOf(str.nextToken());
            int L = Integer.valueOf(str.nextToken());

            edges[D].add(new Edge(E,L));
            edges[E].add(new Edge(D,L));
        }

        dijkstra(dist[0], A);
        dijkstra(dist[1], B);
        dijkstra(dist[2], C);

        int max = 0;
        int index = 1;
        for(int i = 1; i < N; i++){
            if(i == A || i == B || i == C) continue;

            int value = Math.min(dist[0][i], Math.min(dist[1][i], dist[2][i]));
            if(value == Integer.MAX_VALUE) continue;

            if(max < value){
                max = value;
                index = i;
            }
        }
        System.out.println(index);
    }

    private static void dijkstra(int[] dist, int land) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(land, 0));
        dist[land] = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            for(Edge next : edges[edge.x]){
                int nextDist = edge.dist + next.dist;
                if(dist[next.x] <= nextDist) continue;
                dist[next.x] = nextDist;
                pq.add(new Edge(next.x, nextDist));
            }
        }
    }

    public static class Edge implements Comparable<Edge>{
        int x;
        int dist;

        public Edge(int x, int dist){
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o){
            return dist-o.dist;
        }
    }
}

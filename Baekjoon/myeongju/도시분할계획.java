import java.util.*;
import java.io.*;

class Main {

    static int N,M;
    static int[] parent;

    public static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            queue.add(new Edge(Math.min(a,b),Math.max(a,b),c));
        }

        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int dist = 0;
        int cnt = 1;

        while(!queue.isEmpty()) {
            Edge now = queue.poll();

            if(find(now.from) != find(now.to)) {
                union(now.from, now.to);
                dist += now.cost;
                cnt++;
            }

            if(cnt== N-1) {
                System.out.println(dist);
                break;
            }
        }
    }

    public static void union(int a, int b) {

        int p1 = find(a);
        int p2 = find(b);

        if(p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }

    public static int find(int n) {

        if(parent[n]==n) return n;

        else return find(parent[n]);
    }
}
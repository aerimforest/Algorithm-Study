import java.io.*;
import java.util.*;

public class 군사_이동 {
    static int P;
    static int W;
    static int start;
    static int end;
    static PriorityQueue<Edge> edges;
    static int[] parents;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        P = Integer.valueOf(str.nextToken());
        W = Integer.valueOf(str.nextToken());
        parents = new int[P + 1];
        for(int i = 0; i < P; i++) {
            parents[i] = i;
        }

        str = new StringTokenizer(br.readLine());
        start = Integer.valueOf(str.nextToken());
        end = Integer.valueOf(str.nextToken());

        edges = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < W; i++) {
            str = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(str.nextToken());
            int e = Integer.valueOf(str.nextToken());
            int c = Integer.valueOf(str.nextToken());
            edges.add(new Edge(s,e,c));
        }

        makeRoad();
    }

    private static void makeRoad() {
        int min = Integer.MAX_VALUE;
        while(true) {
            Edge edge = edges.poll();
            min = edge.cost;
            union_root(edge.x, edge.y);
            //어차피 최대의 길이를 찾는것이기 때문에 사이클의 여부가 필요 X
            if((parents[start] != edge.x || parents[end] != edge.y)  && find_root(start) == find_root(end)) break;
        }

        System.out.println(min);
    }

    private static boolean union_root(int x, int y) {
        int a = find_root(x);
        int b = find_root(y);

        if(b == a) return true;

        parents[a] = b;
        return false;
    }

    private static int find_root(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find_root(parents[x]);
    }

    public static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

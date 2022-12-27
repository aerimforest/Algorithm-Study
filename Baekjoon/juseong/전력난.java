import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int m, n, min, sum;
    static ArrayList<Edge> edges;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int weight;

        public Edge(int start, int end, int weight) {
            this.x = start;
            this.y = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight; // 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 집의 수, 1 ≤ m ≤ 200000
            n = Integer.parseInt(st.nextToken()); // 길의 수, m-1 ≤ n ≤ 200000
            if (m == 0 && n == 0) break;
            parent = new int[m+1];
            for (int i = 1; i <= m; i++) parent[i] = i;
            edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges.add(new Edge(x, y, weight));
                sum += weight;
            }
            Collections.sort(edges); // 간선 정렬

            for (Edge edge: edges) {
                int x = edge.x, y = edge.y, weight = edge.weight;
                if (find(x) != find(y)) { // 사이클이 생기지 않으면
                    // mst 에 추가
                    min += weight; // mst 가중치 계산
                    union(x, y); // mst 집합에 넣기
                }
            }

            sb.append(sum - min).append("\n"); // 절약할 수 있는 최대 비용
            sum = 0;
            min = 0;
        }
        System.out.print(sb.toString());
    }

    static int find(int x) {
        if (x == parent[x]) {
            return  x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
}

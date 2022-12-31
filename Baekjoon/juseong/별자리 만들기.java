import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] parent;
    static ArrayList<Star> stars;
    static ArrayList<Edge> edges;
    static double ans;

    static class Star {
        double x, y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int x, y;
        double weight;

        public Edge(int x, int y, double weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stars = new ArrayList<Star>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars.add(new Star(x, y));
        }
        for (int i = 0; i < n; i++) {
            double x1 = stars.get(i).x, y1 = stars.get(i).y;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                double x2 = stars.get(j).x, y2 = stars.get(j).y;
                edges.add(new Edge(i, j, get_distance(x1, y1, x2, y2)));
            }
        }
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Collections.sort(edges);
        for (Edge edge: edges) {
            int x = edge.x, y = edge.y;
            double weight = edge.weight;
            if (find(x) != find(y)) {
                ans += weight;
                union(x, y);
            }
        }
        System.out.printf("%.2f", ans);
    }

    static double get_distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
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


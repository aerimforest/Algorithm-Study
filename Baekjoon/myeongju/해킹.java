import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, D, C;
    static ArrayList<Node>[] adjList;
    static int[] d;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[N + 1];
            d = new int[N + 1];

            // n
            for (int i = 1; i <= N; i++)
                adjList[i] = new ArrayList<>();

            // d
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                adjList[b].add(new Node(a, s));
            }

            sb.append(bfs()).append("\n");
        }
        System.out.print(sb);
    }

    public static String bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        Arrays.fill(d, Integer.MAX_VALUE);
        queue.add(new Node(C, 0));
        d[C] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (Node node : adjList[now.to]) {
                if (d[node.to] > d[now.to] + node.sec) {
                    d[node.to] = d[now.to] + node.sec;
                    queue.add(new Node(node.to, d[node.to]));
                }
            }
        }

        int cnt = 0, sec = 0;
        for (int i = 1; i <= N; i++) {
            if (d[i] != Integer.MAX_VALUE) {
                cnt++;
                sec = Math.max(sec, d[i]);
            }
        }

        return cnt + " " + sec;
    }

    public static class Node implements Comparable<Node> {
        int to;
        int sec;

        public Node(int to, int sec) {
            this.to = to;
            this.sec = sec;
        }

        @Override
        public int compareTo(Node o) {
            return this.sec - o.sec;
        }
    }
}
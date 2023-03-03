import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Node>[] list;
    static long[] fox;
    static long[][] wolf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        fox = new long[N + 1];
        wolf = new long[2][N + 1];

        Arrays.fill(fox, Long.MAX_VALUE);
        Arrays.fill(wolf[0], Long.MAX_VALUE);
        Arrays.fill(wolf[1], Long.MAX_VALUE);

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long time = Integer.parseInt(st.nextToken()) * 2L;
            list[from].add(new Node(to, time));
            list[to].add(new Node(from, time));
        }

        dijkstra();
        dijkstra2();

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (fox[i] < Math.min(wolf[0][i], wolf[1][i]))
                cnt++;
        }
        System.out.print(cnt);
    }

    // 여우
    public static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        fox[1] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (fox[now.to] != now.time) continue;

            for (Node next : list[now.to]) {
                long cost = fox[now.to] + next.time;
                if (fox[next.to] > cost) {
                    fox[next.to] = cost;
                    queue.add(new Node(next.to, cost));
                }
            }
        }
    }

    // 늑대
    public static void dijkstra2() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0, 0));
        wolf[0][1] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (wolf[now.state][now.to] != now.time) continue;

            for (Node next : list[now.to]) {
                int state = 1 - now.state;

                long cost = wolf[now.state][now.to] + ((now.state == 0) ? next.time / 2 : next.time * 2);
                if (wolf[state][next.to] > cost) {
                    wolf[state][next.to] = cost;
                    queue.add(new Node(next.to, cost, state));
                }

            }
        }
    }

    public static class Node implements Comparable<Node> {
        int to;
        long time;
        int state;

        public Node(int to, long time) {
            this.to = to;
            this.time = time;
        }

        public Node(int to, long time, int state) {
            this.to = to;
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time < o.time) return -1;
            else return 1;
        }
    }
}


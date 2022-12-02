import java.util.*;
import java.io.*;

class Main {

    static int N;
    static ArrayList<Edge>[] list;
    static int result = 0;
    static int max_node = 0;

    static class Edge{ // 트리(그래프) 저장용
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class Node{ // BFS 탐색용
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] arr = br.readLine().split(" ");
            int idx = Integer.parseInt(arr[0]);
            list[idx] = new ArrayList<>();

            for (int j = 1; j < arr.length; j += 2) {
                if (Integer.parseInt(arr[j]) == -1) break;
                list[idx].add(new Edge(Integer.parseInt(arr[j]),Integer.parseInt(arr[j+1])));
            }
        }

        bfs(1);
        bfs(max_node);

        System.out.println(result);

    }

    public static void bfs(int n) {
        boolean[] v = new boolean[N + 1];

        v[n] = true;
        int max = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n,0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (max < now.cnt) {
                max = now.cnt;
                max_node = now.idx;
            }

            for (Edge to : list[now.idx]) {
                if (v[to.end]) continue;

                v[to.end] = true;
                queue.add(new Node(to.end, now.cnt + to.weight));
            }
        }

        result = Math.max(max, result);
    }
}
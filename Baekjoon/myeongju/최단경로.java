import java.util.*;
import java.io.*;

/*

 */
public class Main {
    static int V, E;
    static int start;
    static ArrayList<Node>[] list;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        arr = new int[V + 1];

        for (int i = 1; i <= V; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dijkstra();
        for (int i = 1; i <= V; i++) {
            if (arr[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(arr[i] + "\n");
        }
        System.out.print(sb);
    }

    public static void dijkstra() {
        Arrays.fill(arr, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.w - o2.w));
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (arr[now.to] != Integer.MAX_VALUE) continue;
            arr[now.to] = now.w;

            for (Node node : list[now.to]) {
                if (arr[node.to] == Integer.MAX_VALUE)
                    queue.add(new Node(node.to, now.w + node.w));
            }
        }
    }

    public static class Node {
        int to;
        int w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
}
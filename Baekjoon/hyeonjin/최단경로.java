import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static int K;
    static List<Node>[] graph;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        V = Integer.valueOf(str.nextToken());
        E = Integer.valueOf(str.nextToken());
        K = Integer.valueOf(br.readLine());

        graph = new ArrayList[V + 1];
        distance = new int[V + 1];
        visited = new boolean[V + 1];

        for(int i = 0; i <= V; i++){
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i =0 ;i < E; i++){
            str = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(str.nextToken());
            int v = Integer.valueOf(str.nextToken());
            int w = Integer.valueOf(str.nextToken());

            graph[u].add(new Node(v,w));
        }

        findMinPath();

        for(int i = 1; i <= V; i++){
            if(i == K) bw.write("0");
            else if(visited[i]) bw.write(String.valueOf(distance[i]));
            else bw.write("INF");
            bw.newLine();
        }

        bw.flush();
    }

    private static void findMinPath() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));
        distance[K] = 0;

        while(!queue.isEmpty()){
            Node now_node = queue.poll();

            for(Node next_node : graph[now_node.index]){
                if(visited[next_node.index] && distance[next_node.index] <= now_node.cost + next_node.cost) continue;

                distance[next_node.index] = now_node.cost + next_node.cost;
                queue.add(new Node(next_node.index, distance[next_node.index]));
                visited[next_node.index] = true;
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }
}

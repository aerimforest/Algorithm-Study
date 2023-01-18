import java.io.*;
import java.util.*;

public class 파티 {
    static int N;
    static int M;
    static int X;
    static List<Node>[] arr;
    static List<Node>[] reverse_arr;
    static int[] dist;
    static int[] reverse_dist;

    public static void main(String[] args) throws Exception{
        inputData();
        dijkstra(arr, dist);
        dijkstra(reverse_arr, reverse_dist);
        printData();
    }

    private static void printData() {
        int max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.max(max, dist[i] + reverse_dist[i]);
        }

        System.out.println(max);
    }

    public static void dijkstra(List<Node>[] nodeList, int[] min){
        boolean[] check = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        min[X] = 0;
        check[X] = true;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            for(Node target : nodeList[node.index]){
                if(check[target.index] || min[target.index] <= min[node.index] + target.dist) continue;

                min[target.index] = min[node.index] + target.dist;
                pq.add(new Node(target.index, min[target.index]));
            }
        }
    }

    public static void inputData() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        X = Integer.valueOf(str.nextToken());

        arr = new List[N + 1];
        reverse_arr = new List[N + 1];

        dist = new int[N + 1];
        reverse_dist = new int[N + 1];

        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<>();
            reverse_arr[i] = new ArrayList<>();

            dist[i] = Integer.MAX_VALUE;
            reverse_dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(str.nextToken());
            int end = Integer.valueOf(str.nextToken());
            int dist = Integer.valueOf(str.nextToken());

            arr[start].add(new Node(end, dist));
            reverse_arr[end].add(new Node(start, dist));
        }
    }
    public static class Node implements  Comparable<Node>{
        int index;
        int dist;

        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }

        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }
}

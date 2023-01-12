import java.io.*;
import java.util.*;

class Node{
    int idx, cost;
    Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
}

public class Main {

    static int N, M ;
    static ArrayList<Node>[] arr;
    static int[] dist, visited;
    static StringBuilder sb;
    static int StartPoint, EndPoint;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new int[N+1];
        sb = new StringBuilder();

        for(int i=0;i<=N;i++) {
            arr[i] = new ArrayList();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[start].add(new Node(end,cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        StartPoint = Integer.parseInt(st.nextToken());
        EndPoint = Integer.parseInt(st.nextToken());

        dijkstra(StartPoint);
        sb.append(dist[EndPoint] + "\n");
        FindRoute();
        bw.write(sb.toString());
        bw.close();
        br.close();
	}

    public static void dijkstra(int start){

        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost,o2.cost));
        q.offer(new Node(start,0));
        dist[start] = 0;
        while(!q.isEmpty()){
            Node curNode = q.poll();
        
            if(dist[curNode.idx] < curNode.cost) continue;
            for(Node nxtNode : arr[curNode.idx]){
                if(dist[nxtNode.idx] > curNode.cost + nxtNode.cost){
                    dist[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    visited[nxtNode.idx] = curNode.idx;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }
    }

    public static void FindRoute(){
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        stack.push(EndPoint);
        while(visited[EndPoint] != 0){
            count += 1;
            stack.push(visited[EndPoint]);
            EndPoint = visited[EndPoint];
        }
        sb.append((count+1)+"\n");
        while(!stack.isEmpty()) sb.append(stack.pop() + " ");
    }
}


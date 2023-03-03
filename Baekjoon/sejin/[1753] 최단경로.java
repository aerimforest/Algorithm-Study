import java.io.*;
import java.util.*;

public class Main {

	static int V,E, startNode;

	static ArrayList<Node>[] list;
	static int[] dist; 
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		startNode = Integer.parseInt(br.readLine());

		list = new ArrayList[V+1];
		dist = new int[V+1];

		for (int i=0; i<=V; i++) list[i] = new ArrayList<>();
		Arrays.fill(dist,INF);
		dist[startNode] = 0;

		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[u].add(new Node(v,w));
		}

		dijkstra();

		for(int i=1; i<=V; i++){
			if (dist[i] == INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}

	}

	public static void dijkstra(){
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startNode, 0));
		while (!pq.isEmpty()){
			Node node = pq.poll();
			if(dist[node.vertex] < node.edge) continue;
			for(int i=0;i<list[node.vertex].size();i++){
				Node NewNode = list[node.vertex].get(i);
				int NewV = NewNode.vertex;
				int NewE = NewNode.edge + node.edge;
				if(dist[NewV] > NewE){
					dist[NewV] = NewE;
					pq.add(new Node(NewV, NewE));
				}
			}

		}
	}

	public static class Node implements Comparable<Node> {
		int vertex;
		int edge;

		public Node(int vertex,int edge){
			this.vertex = vertex;
			this.edge = edge;
		}

		@Override
		public int compareTo(Main.Node o) {
			return edge - o.edge;
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, A, B, C;
	static int[] dist;
	static ArrayList<int[]>[] graph;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dijkstra(A);
		dijkstra(B);
		dijkstra(C);
		
		int maxIdx = -1;
		int maxDist = 0;
		
		for(int i=0; i<N; i++) {
//			System.out.print(dist[i] + " ");
			if(dist[i]==0)
				continue;
			if(maxDist < dist[i]) {
				maxDist = dist[i];
				maxIdx = i;
			}
		}
//		System.out.println();
		System.out.println(maxIdx + 1);
	}

	
	private static void dijkstra(int start) {
		int[] thisDist = new int[N];
		Arrays.fill(thisDist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o->o[1]));
		pq.add(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int goal = cur[0];
			int weight = cur[1];
			
			if(thisDist[goal] < weight)
				continue;
			thisDist[goal] = weight;
			
			for(int[] next : graph[goal]) {
				if(thisDist[next[0]] > next[1] + weight) {
					pq.add(new int[] {next[0], next[1] + weight});
				}
			}
		}
		for(int i=0; i<N; i++) {
//			System.out.print(thisDist[i] + " ");
			dist[i] = Math.min(dist[i], thisDist[i]);
		}
//		System.out.println();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<int[]>();
		}
		
		st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken()) -1;
		B = Integer.parseInt(st.nextToken()) -1;
		C = Integer.parseInt(st.nextToken()) -1;
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken()) - 1;
			int E = Integer.parseInt(st.nextToken()) - 1;
			int L = Integer.parseInt(st.nextToken());
			
			graph[D].add(new int[] {E, L});
			graph[E].add(new int[] {D, L});
		}
		
		br.close();
	}
}

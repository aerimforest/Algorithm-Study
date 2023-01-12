import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, start, goal;
	static ArrayList<int[]>[] list;
	
	public static void main(String[] args) throws IOException {
		input();
		por();
	}

	private static void por() {
		int[] route = new int[N+1];
		int[] dist = new int[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o->o[1]));
		pq.add(new int[] {start, 0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int pos = cur[0];
			int weight = cur[1];
			
			if(dist[pos] < weight)
				continue;
			
			for(int[] next : list[pos]) {
				if(dist[next[0]] > dist[pos] + next[1]) {
					dist[next[0]] = dist[pos] + next[1];
					route[next[0]] = pos;
					pq.offer(new int[] {next[0], dist[next[0]]});
				}
			}
		}
		System.out.println(dist[goal]);
		
		int idx = goal;
		Stack<Integer> routes = new Stack<>();

		while(idx != 0) {
			routes.add(idx);
			idx = route[idx];
		}
		System.out.println(routes.size());
		
		while(!routes.isEmpty())
			System.out.print(routes.pop() + " ");
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for(int i=0; i<=N; i++)
			list[i] = new ArrayList<int[]>();
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new int[] {e, w});
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		
		br.close();
	}
}

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		List<Vertex>[] list = new ArrayList[v+1];
		for (int i = 0; i < v + 1; i++)
			list[i] = new ArrayList<Vertex>();
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Vertex(to, weight));
		}
		
		final int max = Integer.MAX_VALUE;
		for (int x = 1; x <= v; x++) {
			int end = x;
			if (end == start) {
				System.out.println(0);
				continue;
			}
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			int[] distance = new int[v + 1];
			Arrays.fill(distance, max);
			boolean[] visit = new boolean[v + 1];
			distance[start] = 0;
			pq.offer(new Vertex(start, distance[start]));
			
			Vertex cur = null;
			while (!pq.isEmpty()) {
				cur = pq.poll();
				if (distance[cur.no] < cur.total || visit[cur.no]) continue;
				visit[cur.no] = true;
				if (cur.no == end) break;
				
				for (int i = 0; i < list[cur.no].size(); i++) {
					Vertex next = list[cur.no].get(i);
					if (!visit[next.no] && distance[next.no] > distance[cur.no] + next.total) {
						distance[next.no] = distance[cur.no] + next.total;
						pq.offer(new Vertex(next.no, distance[next.no]));
					}
				}
			}
			int ans = distance[end];
			if (ans == max) 
				System.out.println("INF");
			else
				System.out.println(ans);
		}
		
	}
	
	static class Vertex implements Comparable<Vertex>{
		int no;
		int total;
		
		public Vertex(int no, int total) {
			this.no = no;
			this.total = total;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.total-o.total;
		}

	}
}

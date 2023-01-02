import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {
	
	static int V, E, start;
	static ArrayList<int[]>[] list;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	// 다익스트라 문제
	private static void pro() {
		// start에서의 거리
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
		pq.add(new int[] {start, 0});
		
		// 우선순위 큐보기
		while(!pq.isEmpty()) {
			// cur[0] 목적지
			// cur[1] 무게
			int[] cur = pq.poll();
			int goal = cur[0];
			int weight = cur[1];
			
			// 현재 값 보다 가중치가 심하면 넘어감
			if(dist[goal] < weight)
				continue;
			// 현재 값이 가중치보다 작으니 넣어준다.
			dist[goal] = weight;
			
			// 이제 근접이 되어 있는 애들을 돌면서 봐준다
			for(int[] next : list[goal]) {
				// 기록이 지금 가는 것 보다 작으면 우선순위 큐에 넣어준다.
				if(dist[next[0]] > next[1] + weight) {
					pq.add(new int[] {next[0], next[1] + weight});
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else
				System.out.println(dist[i]);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		start = Integer.parseInt(br.readLine());
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new int[] {v, w});
		}
		br.close();
	}
}

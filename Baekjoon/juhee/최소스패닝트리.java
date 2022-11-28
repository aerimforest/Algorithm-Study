import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 : 600ms
// 메모리 : 55332KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<int[]>[] list = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			list[a].add(new int[] {b, w});
			list[b].add(new int[] {a, w});
		}
		
		boolean[] v = new boolean[V];
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		long total = 0l;
		que.offer(new int[] {0,0});
		while(V > 0) {
			int[] cur = que.poll();
			if(v[cur[0]]) continue;
			V--;
			v[cur[0]] = true;
			total += cur[1];
			for (int[] i : list[cur[0]]) {
				if(v[i[0]]) continue;
				que.offer(i);
			}
		}
		System.out.println(total);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분 그래프 {
	static int V;
	static int[] check;
	static boolean[] visit;
	static ArrayList<Integer>[] list;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(sb);
	}

	private static void pro() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0; i<V; i++) {
			if(check[i] == 0) {
				queue.add(i);
				check[i] = 1;
			}
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				
				for(int next : list[cur]) {
					if (check[next] == 0) {
						queue.add(next);
					}
					
					if(check[next] == check[cur]) {
						sb.append("NO\n");
						return;
					}
					
					check[next] = check[cur] * -1;
				}
			}
		}
		sb.append("YES\n");
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			check = new int[V];
			visit = new boolean[V];
			list = new ArrayList[V];
			
			for(int j=0; j<V; j++) {
				list[j] = new ArrayList<Integer>();
			}
			
			for(int j=0; j<E; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				
				list[u].add(v);
				list[v].add(u);
			}
			pro();
		}
		br.close();
	}
}

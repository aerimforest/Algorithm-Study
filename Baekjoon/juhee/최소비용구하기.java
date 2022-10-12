import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 372ms
// 메모리 : 45900KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<int[]>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			list[start].add(new int[] {end, w});
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		System.out.println(dijkstra(list, start, end));
	}

	private static int dijkstra(List<int[]>[] list, int start, int end) {

		int N = list.length;
		int[] dist = new int[N];
		Arrays.fill(dist, 987654321);
        dist[start] = 0;
		for (int[] i : list[start]) {
			if(dist[i[0]] > i[1]) dist[i[0]] = i[1];
		}
		boolean[] v = new boolean[N];
		for (int i = 0; i < N; i++) {
			int n = find_smallest_node(dist, v);
			if(n==-1) continue;
            v[n] = true;
			for (int[] b : list[n]) {
				if(dist[b[0]] > dist[n] + b[1]) {
					dist[b[0]] = dist[n] + b[1];
				}
			}
		}
		return dist[end];
	}

	private static int find_smallest_node(int[] dist, boolean[] v) {

		int N = dist.length;
		int min = 987654321;
		int node = -1;
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			if(dist[i] < min) {
				min = dist[i];
				node = i;
			}
		}
		return node;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 432ms
// 메모리 : 19876KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		List<int[]>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			list[start].add(new int[] {end, w});
			list[end].add(new int[] {start, w});
		}
		int[] dist = new int[N];
		int n = dijkstra(list, 0, dist);
		int e = dijkstra(list, n, dist);
		int total = dist[e];
		System.out.println(total);
	}

	private static int dijkstra(List<int[]>[] list, int x, int[] dist) {

		int N = list.length;
		Arrays.fill(dist, 987654321);
		for (int[] j : list[x]) {
			dist[j[0]] = j[1];
		}
		dist[x] = 0;
		
		boolean[] v = new boolean[N];
		v[x] = true;
		for (int i = 0; i < N-1; i++) {
			int n = smallest_node(dist, v);
			if(n == -1) continue;
			v[n] = true;
			for (int[] b : list[n]) {
				if(dist[b[0]] > dist[n] + b[1]) {
					dist[b[0]] = dist[n] + b[1];
				}
			}
		}
		int max = -1;
		int node = -1;
		for (int i = 0; i < N; i++) {
			if(max < dist[i]) {
				max = dist[i];
				node = i;
			}
		}
		return node;
	}

	private static int smallest_node(int[] dist, boolean[] v) {
		int N = dist.length;
		int min = 987654321;
		int node = -1;
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			if(min > dist[i]) {
				min = dist[i];
				node = i;
			}
		}
		return node;
	}

}

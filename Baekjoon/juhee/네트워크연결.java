import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 : 528ms
// 메모리 : 56888KB
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
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new int[] {end, weight});
			list[end].add(new int[] {start, weight});
		}
		
		System.out.println(find_min_dist(list));
	}

	private static int find_min_dist(List<int[]>[] list) {

		int N = list.length;
		boolean[] v = new boolean[N];
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int total = 0;
		que.offer(new int[] {0,0});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(v[cur[0]]) continue;
			v[cur[0]] = true;
			total += cur[1];
			for (int[] i : list[cur[0]]) {
				que.offer(new int[] {i[0], i[1]});
			}
		}
		return total;
	}

}

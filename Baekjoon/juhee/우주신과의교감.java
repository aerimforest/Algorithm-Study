import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 : 316ms
// 메모리 : 41596KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] god = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			god[i] = new ArrayList<>();
		}
		
		long[][] rc = new long[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			rc[i][0] = Long.parseLong(st.nextToken());
			rc[i][1] = Long.parseLong(st.nextToken());
		}
		
		double[][] dist = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				double tmp = Math.sqrt((rc[i][0] - rc[j][0]) * (rc[i][0] - rc[j][0]) + (rc[i][1] - rc[j][1])* (rc[i][1] - rc[j][1]));
				dist[i][j] = tmp;
				dist[j][i] = tmp;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken())-1;
			int t2 = Integer.parseInt(st.nextToken())-1;
			god[t1].add(t2);
			god[t2].add(t1);
		}
		
		boolean[] v = new boolean[N];
		PriorityQueue<Star> que = new PriorityQueue<>();
		que.offer(new Star(0, 0));
		int cnt = 0;
		double total = 0d;
		while(!que.isEmpty()) {
			Star cur = que.poll();
			if(v[cur.idx]) continue;
			v[cur.idx] = true;
			total += cur.dist;
			cnt++;
			if(cnt == N) break;
			for (Integer s : god[cur.idx]) {
				if(v[s]) continue;
				que.offer(new Star(s, 0d));
			}
			for (int i = 0; i < N; i++) {
				if(v[i]) continue;
				que.offer(new Star(i, dist[cur.idx][i]));
			}
		}
		System.out.printf("%.2f", total);
	}
	
	static class Star implements Comparable<Star> {
		int idx;
		double dist;
		
		public Star(int idx, double dist) {
			this.idx = idx;
			this.dist = dist;
		}
		@Override
		public int compareTo(Star o) {
			return Double.compare(this.dist, o.dist);
		}
	}

}

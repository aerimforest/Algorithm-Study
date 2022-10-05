import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 260ms
// 메모리 : 30348KB
public class Main {
	
	static class Node {
		int sr;
		int sc;
		int er;
		int ec;
		
		public Node(int sr, int sc, int er, int ec) {
			this.sr = sr;
			this.sc = sc;
			this.er = er;
			this.ec = ec;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j*2) -'0';
				if(map[i][j] == 1) map[i][j] = -1;
			}
		}
		int[] bj = new int[2];
		st = new StringTokenizer(br.readLine());
		bj[0] = Integer.parseInt(st.nextToken()) - 1;
		bj[1] = Integer.parseInt(st.nextToken()) - 1;
		
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken()) - 1;
			int sc = Integer.parseInt(st.nextToken()) - 1;
			int er = Integer.parseInt(st.nextToken()) - 1;
			int ec = Integer.parseInt(st.nextToken()) - 1;
			list.add(new Node(sr, sc, er, ec));
			map[sr][sc] = i + 1;
		}
		
		System.out.println(find_person(map, list, bj, K));
	}
	private static int find_person(int[][] map, List<Node> list, int[] bj, int k) {

		int total = 0;
		int N = map.length;
		int M = list.size();
		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		
		// 총 M개의 쌍이 존재
		for (int t = 0; t < M; t++) {
			// 가장 가까운 승객을 찾기 위해 bfs
			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[] {bj[0], bj[1], k, 0}); // r, c, 연료량, step
			boolean[][] v = new boolean[N][N];
			v[bj[0]][bj[1]] = true;
			
			int customer = -1;
			int mindist = Integer.MAX_VALUE;
			
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				// 가진 연료보다 많이 걸었으면 리턴 -1
				if(cur[3] > cur[2]) {
					continue;
				}
				// 사람 있는 데에 도착했으면 연료 빼주고 도착지까지 이동
				if(map[cur[0]][cur[1]] > 0) {
					int n = map[cur[0]][cur[1]];
					if(cur[3] < mindist) {
						mindist = cur[3];
						customer = n;
					} else if(cur[3] == mindist) {
						Node prev = list.get(customer-1);
						if(prev.sr > cur[0]) {
							customer = n;
						} else if(prev.sr == cur[0]) {
							if(prev.sc > cur[1]) {
								customer = n;
							}
						}
					}
				}
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
					if(v[nr][nc] || map[nr][nc] == -1) continue;
					v[nr][nc] = true;
					que.offer(new int[] {nr, nc, cur[2], cur[3] + 1});
				}
			}
			if(customer == -1) return -1;
			Node cus = list.get(customer-1);
			map[cus.sr][cus.sc] = 0;
			bj[0] = cus.sr;
			bj[1] = cus.sc;
			k = go_to_dest(map, cus, bj, k - mindist);
			if(k == -1) return -1;
		}
		return k;
	}
	
	private static int go_to_dest(int[][] map, Node node, int[] bj, int k) {

		int N = map.length;
		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {bj[0], bj[1], k, 0});
		boolean[][] v= new boolean[N][N];
		v[bj[0]][bj[1]] = true;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[3] > cur[2]) return -1;
			if(cur[0] == node.er && cur[1] == node.ec) {
				bj[0] = node.er;
				bj[1] = node.ec;
				return cur[2] + cur[3];
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= N || nc >= N|| nr < 0 || nc < 0) continue;
				if(v[nr][nc] || map[nr][nc] == -1) continue;
				v[nr][nc] = true;
				que.offer(new int[] {nr, nc, cur[2], cur[3] + 1});
			}
		}
		return -1;
	}

}

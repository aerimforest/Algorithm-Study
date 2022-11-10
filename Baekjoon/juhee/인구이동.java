import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 636ms
// 메모리 : 295504
public class Main {

	static int L;
	static int R;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(move(map)) {
			time++;
		}
		System.out.println(time);
	}
	private static boolean move(int[][] map) {

		int N = map.length;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		int[][] newmap = new int[N][N];
		boolean[][] v = new boolean[N][N];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(v[i][j]) continue;
				Queue<int[]> que = new LinkedList<>();
				Queue<int[]> tmp = new LinkedList<>();
				que.offer(new int[] {i, j});
				v[i][j] = true;
				int cnt = 1;
				int people = map[i][j];
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					tmp.offer(cur);
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
						if(v[nr][nc]) continue;
						if(Math.abs(map[nr][nc] - map[cur[0]][cur[1]]) >= L && Math.abs(map[nr][nc] - map[cur[0]][cur[1]]) <= R) {
							v[nr][nc] = true;
							cnt++;
							people += map[nr][nc];
							que.offer(new int[] {nr, nc});
							flag = true;
						}
					}
						
				}
				int total = people/cnt;
				while(!tmp.isEmpty()) {
					int[] cur = tmp.poll();
					newmap[cur[0]][cur[1]] = total;
				}
			}
		}
		if(!flag) return false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = newmap[i][j];
			}
		}
		return true;
	}

}

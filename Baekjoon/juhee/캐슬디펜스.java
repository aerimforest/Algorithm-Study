import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 232ms
// 메모리 : 36012KB
public class Main {

	static int D;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		archer(0, 0, new int[3], map);
		System.out.println(max);
	}

	static int max;
	private static void archer(int cnt, int start, int[] loc, int[][] map) {

		int N = map.length;
		int M = map[0].length;
		if(cnt == 3) {
			int total = kill_monster(loc, map);
			max = Math.max(max, total);
			return;
		}
		
		for (int i = start; i < M; i++) {
			loc[cnt] = i;
			archer(cnt+1, i+1, loc, map);
		}
	}

	private static int kill_monster(int[] loc, int[][] map) {

		int N = map.length;
		int M = map[0].length;
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int total = 0;
		
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		while(true) {
			List<int[]> monster = new ArrayList<int[]>();
			for(int i = 0; i < 3; i++) {
				Queue<int[]> que = new LinkedList<>();
				boolean[][] v = new boolean[N][M];
				que.offer(new int[] {N, loc[i], 0});
				int r = N;
				int c = M;
				int min = Integer.MAX_VALUE;
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					if(cur[2] > min) continue;
					if(cur[2] == D) continue;
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
						if(v[nr][nc]) continue;
						v[nr][nc] = true;
						que.offer(new int[] {nr, nc, cur[2] + 1});
						if(tmp[nr][nc] == 1) {
							if(min > cur[2]) {
								min = cur[2];
								r = nr;
								c = nc;
							} else if(min == cur[2]) {
								if(c > nc) {
									r = nr;
									c = nc;
								}
							}
						}
					}
					
				}
				if(r != N) monster.add(new int[] {r, c});
			}
			for (int[] is : monster) {
				if(tmp[is[0]][is[1]] == 1) total++;
				tmp[is[0]][is[1]] = 0;
			}
			if(monster_down(tmp)) break;
		}
		return total;
	}

	private static boolean monster_down(int[][] tmp) {

		int N = tmp.length;
		int M = tmp[0].length;
		for (int i = N-1; i > 0; i--) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = tmp[i-1][j];
			}
		}
		for (int i = 0; i < M; i++) {
			tmp[0][i] = 0;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tmp[i][j] == 1) return false;
			}
		}
		return true;
	}



}

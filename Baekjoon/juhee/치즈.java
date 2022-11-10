import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 296ms
// 메모리 : 46552KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(remove_cheese(map)) time++;
		System.out.println(time);
	}

	private static boolean remove_cheese(int[][] map) {

		int N = map.length;
		int M = map[0].length;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0});
		int[][] v = new int[N][M];
		v[0][0] = 1;
		List<int[]> list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			if(map[0][i] == 0) {
				que.offer(new int[] {0,i});
				v[0][i] = 1;
			}
			if(map[N-1][i] == 0) {
				v[N-1][i] = 1;
				que.offer(new int[] {N-1, i});
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(map[i][0] == 0) {
				que.offer(new int[] {i, 0});
				v[i][0] = 1;
			}
			if(map[i][M-1] == 0) {
				que.offer(new int[] {i, M-1});
				v[i][0] = 1;
			}
		}
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
				if(map[nr][nc] == 1) {
					v[nr][nc]++;
					if(v[nr][nc] == 2) {
						list.add(new int[] {nr, nc});
					}
				} else {
					if(v[nr][nc] == 1) continue;
					que.offer(new int[] {nr, nc});
					v[nr][nc] = 1;
				}
			}
			
		}
		if(list.size() == 0) return false;
		for (int[] is : list) {
			map[is[0]][is[1]] = 0;
		}
		return true;
	}

}

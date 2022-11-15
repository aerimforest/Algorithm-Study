import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 92ms
// 메모리 : 13024KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			map[y1][x1] += 1;
			if(x2 < M) 
				map[y1][x2] += -1;
			if(y2 < N) 
				map[y2][x1] += -1;
			if(y2 < N && x2 < M) 
				map[y2][x2] += 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < M; j++) {
				map[i][j] += map[i][j-1];
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] += map[i-1][j];
			}
		}
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0) continue;
				Queue<int[]> que = new LinkedList<>();
				que.offer(new int[] {i, j});
				map[i][j] = 2;
				int cnt = 0;
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					cnt++;
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if(nr < 0 || nc < 0|| nr >= N || nc >= M) continue;
						if(map[nr][nc] != 0) continue;
						map[nr][nc] = 2;
						que.offer(new int[] {nr, nc});
					}
				}
				list.add(cnt);
			}
		}
		list.sort(null);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (Integer integer : list) {
			sb.append(integer).append(" ");
		}
		System.out.println(sb);
	}

}

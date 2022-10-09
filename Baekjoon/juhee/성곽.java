import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// 서 북 동 남
		boolean[][][] map = new boolean[N][M][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int wall = Integer.parseInt(st.nextToken());
				for (int d = 0; d < 4; d++) {
					if((wall & (1 << d)) != 0) {
						map[i][j][d] = true;
					}
				}
			}
		}
		
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};
		
		int[][] v = new int[N][M];
		List<int[]> nearby = new ArrayList<>();
		Map<Integer, Integer> room_size = new HashMap<>();
		int group = 1;
		
		int max_room = -1;
		int max_room1 = -1;
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < M; j++) {
				if(v[i][j] > 0) continue;
				int cnt = 0;
				Queue<int[]> que = new LinkedList<>();
				que.offer(new int[] {i, j});
				v[i][j] = group;
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					cnt++;
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
						if(map[cur[0]][cur[1]][d]) {
							if(v[nr][nc] > 0 && v[nr][nc] != group) nearby.add(new int[] {v[nr][nc], group});
							continue;
						}
						if(v[nr][nc] > 0) continue;
						v[nr][nc] = group;
						que.offer(new int[] {nr, nc});
					}
				}
				room_size.put(group, cnt);
				if(cnt > max_room) max_room = cnt;
				group++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(room_size.size()).append("\n");
		sb.append(max_room).append("\n");
		
		int max_room2 = -1;
		for (int[] is : nearby) {
			int f = room_size.get(is[0]);
			int s = room_size.get(is[1]);
			if(max_room2 < f + s) {
				max_room2 = f + s;
			}
		}
		sb.append(max_room2);
		System.out.println(sb);
		
	}

}

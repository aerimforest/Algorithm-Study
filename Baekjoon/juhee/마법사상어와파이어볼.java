import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 736ms
// 메모리 : 171932KB
public class Main {

	static class Fire {
		int r;
		int c;
		int m;
		int d;
		int s;
		
		public Fire (int r, int c, int m, int d, int s) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Fire>[][] map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new Fire(r,c,m,d,s));
		}
		
		while(--K >= 0) {
			map = fire_move(map);
		}
		
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Fire fire : map[i][j]) {
					total += fire.m;
				}
			}
		}
		System.out.println(total);
	}
	
	private static List<Fire>[][] fire_move(List<Fire>[][] map) {
 
		int N = map.length;
		int[] dr = {-1,-1,0,1,1,1,0,-1};
		int[] dc = {0,1,1,1,0,-1,-1,-1};
		
		List<Fire>[][] tmp = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Fire fire : map[i][j]) {
					int nr = fire.r + (dr[fire.d]*fire.s + N) % N;
					int nc = fire.c + (dc[fire.d]*fire.s + N) % N;
					if(nr >= N) nr %= N;
					else if(nr < 0) nr += N;
					if(nc >= N) nc %= N;
					else if(nc < 0) nc += N;
					tmp[nr][nc].add(new Fire(nr, nc, fire.m, fire.d, fire.s));
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(tmp[i][j].size() < 2) continue;
				int cnt = tmp[i][j].size();
				int total_m = 0;
				int total_s = 0;
				boolean dir = tmp[i][j].get(0).d % 2 == 0 ? true : false;
				boolean flag = true; // 모두 짝수 or 홀수
				for (Fire fire : tmp[i][j]) {
					total_m += fire.m;
					total_s += fire.s;
					if(dir != (fire.d % 2 == 0 ? true : false)) {
						flag = false;
					}
				}
				total_m /= 5;
				total_s /= cnt;
				tmp[i][j].clear();
                if(total_m == 0) continue;
				int d = 0;
				if(!flag) d = 1;
				for (int k = d; k < 8; k+=2) {
					tmp[i][j].add(new Fire(i,j,total_m, k, total_s));
				}
			}
		}
		return tmp;
	}

}

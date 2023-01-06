import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
	static int N, M, max;
	static int [][] mat;
	static boolean [][] visit;
	
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, -1, 0, 1};
	
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				dfs(i, j, 0, 0);
			}
		}
		System.out.println(max);
	}

	private static void dfs(int x, int y, int cnt, int sum) {
		if(cnt==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int di = 0; di<4; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
			if(visit[nx][ny]) continue;
			
			// 뒤로 갔다가 다시 4방 탐색으로 ㅗ만들기
			if(cnt==2) {
				visit[nx][ny] = true;
				dfs(x, y, cnt+1, sum + mat[nx][ny]);
				visit[nx][ny] = false;
			}
			
			visit[nx][ny] = true;
			dfs(nx, ny, cnt+1, sum+mat[nx][ny]);
			visit[nx][ny] = false;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
}

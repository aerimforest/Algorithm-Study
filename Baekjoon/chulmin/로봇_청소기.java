import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇_청소기.java {
	static int N, M, count, r, c, d, rcnt;
	static int[] dirx = new int[] {-1, 0, 1, 0};
	static int[] diry = new int[] {0, 1, 0, -1};
	
	static int[][] mat;
	static boolean[][] used;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		count = 0;
		while(true) {
			// 1. 현재 위치를 청소한다.
			clean();
			// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향으로 탐색을 진행한다.
			if(!canGo()) {
				break;
			}
		}
		System.out.println(count);
	}

	private static boolean canGo() {
//		System.out.println(r + " " + c + " " + d);
		// 1. 왼쪽 방향에 아직 청소하지 않는 공간이 존재한다면,
		// 그 방향으로 회전한 다음 한 칸을 전진 1번 부터 진행
		int nd = (d + 3) % 4; 
		int nx = r + dirx[nd];
		int ny = c + diry[nd];
		
		if(mat[nx][ny] == 0 && !used[nx][ny]) {
			d = nd;
			r = nx;
			c = ny;
			rcnt = 0;
			return true;
		}
		
		// 2. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 go()호출.
		// 돌린 카운터가 4밑이면 한번 더 찾기
		else if(rcnt < 4) {
			d = nd;
			rcnt++;
			return canGo();
		}
		
		
		//네 방향 모두 청소가 이미 되어있거나 벽인 경우에는
		else if(rcnt == 4) {
			// 3. 바라보는 방향을 유지한 채로 한 칸 후진을 학 go()호출.
			nd = (d + 2) % 4;
			nx = r + dirx[nd];
			ny = c + diry[nd];
			if(mat[nx][ny]==0) {
				r = nx;
				c = ny;
				rcnt = 0;
				return true;
			}
			// 4. 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
			else if(mat[nx][ny]==1) {
				return false;
			}
		}
		return true;
	}

	private static void clean() {
		if(used[r][c])
			return;
		used[r][c] = true;
		count++;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		used = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();		
	}
}

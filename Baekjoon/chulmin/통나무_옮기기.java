import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 통나무_옮기기 {
	static int N, bdir, edir, answer;
	static int [] bidx, eidx;
	static public char[][] mat;
	static public boolean[][][] visit;
	
	static int[] dirx = {-1, 1, 0, 0};
	static int[] diry = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		input();
		pro();
	}

	// 완전 탐색
	private static void pro() {
		answer = Integer.MAX_VALUE;
		bfs();
		if(answer == Integer.MAX_VALUE)
			answer = 0;
		System.out.println(answer);
	}

	private static void bfs() {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[bidx[0]][bidx[1]][bdir] = true;
		queue.add(new int[] {bidx[0], bidx[1], bdir, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
//			System.out.println(cur[0] + " " + cur[1] + " " + cur[2] + " " + cur[3]);
			
			if(cur[0]==eidx[0] && cur[1]==eidx[1] && cur[2]==edir) {
				answer = Math.min(cur[3], answer);
				return;
			}
			
			// u, d, l, r
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(visit[nx][ny][cur[2]]) continue;
				if(mat[nx][ny]=='1') continue;
				if(check(nx, ny, cur[2])) {
					visit[nx][ny][cur[2]] = true;
					queue.add(new int[] {nx, ny, cur[2], cur[3]+1});
				}
			}
			
			// t
			int ndir = 1 - cur[2];
			if(visit[cur[0]][cur[1]][ndir]) continue;
			if(canTurn(cur[0], cur[1])) {
				visit[cur[0]][cur[1]][ndir] = true;
				queue.add(new int[] {cur[0], cur[1], ndir, cur[3]+1});
			}
		}
	}

	private static boolean canTurn(int x, int y) {
		// 중앙이 테두리에 있으면 안된다.
		if(x==0 || y == 0 || x == N-1 || y == N-1) {
			return false;
		}
		
		// 3 by 3 확인하기
		for(int i=-1; i<=1; i++) {
			for(int j=-1; j<=1; j++) {
				if(mat[x+i][y+j]=='1')
					return false;
			}
		}
		return true;
	}

	private static boolean check(int x, int y, int di) {
		if(mat[x][y]==1) return false;
		if(di == 0) {
			if(x==0 || x==N-1) return false;
			if(mat[x-1][y]=='1') return false;
			if(mat[x+1][y]=='1') return false;
		}
		else if(di == 1) {
			if(y==0 || y==N-1) return false;
			if(mat[x][y-1]=='1') return false;
			if(mat[x][y+1]=='1') return false;
		}
		return true;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new char[N][N];
		visit = new boolean[N][N][2];
		
		int bcnt = 0;
		int ecnt = 0;
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				mat[i][j] = line.charAt(j);
				if(mat[i][j]=='B') {
					bcnt++;
					
					if(bcnt==2) {
						if(bidx[0] == i-1) 
							bdir = 0;
						else bdir = 1;
					}
					if(bcnt!=3)
						bidx = new int[] {i, j};
				}
				
				if(mat[i][j]=='E') {
					ecnt++;
					if(ecnt==2) {
						if(eidx[0] == i-1)
							edir = 0;
						else edir = 1;
					}
					if(ecnt!=3)
						eidx = new int[] {i, j};
				}
			}
		}
		br.close();		
	}
}

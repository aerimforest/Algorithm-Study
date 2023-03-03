import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int N, M, size, wcnt, answer;
	static Point[] viruses = new Point[10];
	static boolean[] choose = new boolean[10];
	static int[][] mat;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		answer = Integer.MAX_VALUE;
		dfs(0,0);
		if(answer == Integer.MAX_VALUE)
			answer = -1;
		System.out.println(answer);
	}

	private static void dfs(int start, int depth) {
		if(depth==M) {
			check();
			return;
		}
		
		for(int i=start; i<size; i++) {
			choose[i] = true;
			dfs(i+1, depth+1);
			choose[i] = false;
		}
	}

	private static void check() {
		int[][] time = new int[N][N];
		
		// 바이러스들을 -1로 기록한다.
		for(int i=0; i<size; i++) {
			Point p = viruses[i];
			time[p.x][p.y] = -1;
		}

		boolean[][] visit = new boolean[N][N];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<size; i++) {
			if(choose[i]) {
				queue.add(new int[] {viruses[i].x, viruses[i].y, 1});
				time[viruses[i].x][viruses[i].y] = 1;
			}
		}
		
		int cnt = size;
		int max = 0;
		
		if(cnt + wcnt == N * N) {
			answer = Math.min(answer, 0);
			return;
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int di = 0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(time[nx][ny] > 0) continue;
				if(mat[nx][ny]==1) continue;
				
				if(time[nx][ny] != -1) 
					cnt++;
				queue.add(new int[] {nx, ny, cur[2]+1});
				max = Math.max(cur[2] + 1, max);
				time[nx][ny] = cur[2]+1;
			}
			
			if(cnt + wcnt == N * N) {
				answer = Math.min(answer, max - 1);
				break;
			}
		}
		
//		System.out.println(max);
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(time[i][j] + " ");
//			}System.out.println();
//		}System.out.println();
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		size = 0;
		wcnt = 0;
		
		mat = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j]==2) {
					viruses[size++] = new Point(i, j); 
				}
				else if(mat[i][j]==1)
					wcnt++;
			}
		}
		
		br.close();
	}
}

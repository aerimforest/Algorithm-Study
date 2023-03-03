import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K, W, H;
	static int[][] mat;
	static boolean[][][] visit;

	static int[] dirx = {-1, 0, 1, 0, -1, -2, -2, -1, 1, 2, 2, 1};
	static int[] diry = {0, -1, 0, 1, -2, -1, 1, 2, -2, -1, 1, 2};
	
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		visit[0][0][0] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {0,0,0,0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if(cur[0] == H-1 && cur[1] == W-1) {
				System.out.println(cur[3]);
				return;
			}
			
			int used = cur[2];
			int depth = cur[3];
			
			for(int di=0; di<12; di++) {
				if(di == 4 && used == K) break;
				
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];

				
				if(nx<0||ny<0||nx>=H||ny>=W)
					continue;
				if(di>=4) {
					if(mat[nx][ny] == 1|| visit[nx][ny][used + 1])
						continue;
					visit[nx][ny][used + 1] = true;
					queue.add(new int[] {nx, ny, used+1, depth+1});
				}
				else {
					if(mat[nx][ny] == 1 || visit[nx][ny][used])
						continue;
					visit[nx][ny][used] = true;
					queue.add(new int[] {nx, ny, used, depth+1});
				}
			}
			
		}
		System.out.println(-1);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		mat = new int[H][W];
		visit = new boolean[H][W][K+1];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
}

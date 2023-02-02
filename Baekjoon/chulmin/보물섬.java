import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static char[][] mat;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();	
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j);
			}
		}
		
		max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(mat[i][j] == 'L')
					check(i,j);
			}
		}
		
		System.out.println(max);
		br.close();
	}
	private static void check(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visit = new boolean[N][M];
		
		queue.add(new int[] {i, j, 0});
        visit[i][j] = true;
        
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			max = Math.max(max, cur[2]);
			
			for(int di = 0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0||nx>=N||ny>=M)
					continue;
				if(mat[nx][ny] == 'W')
					continue;
				if(visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				queue.add(new int[] {nx, ny, cur[2] + 1});
			}
		}
	}
}

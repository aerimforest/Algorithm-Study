import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, wcnt, max;
	static int[][] mat;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		wcnt = 0;
		max = 0;
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j] == -1) 
					wcnt++;
				else if(mat[i][j] == 1)
					queue.add(new int[] {i, j, 1});
			}
		}
		
		int count = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			count ++;
			
			if(max < cur[2]) {
				max = cur[2];
			}
			
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				
				if(nx<0||ny<0|| nx>=N|| ny>=M)
					continue;
				if(mat[nx][ny]!=0)
					continue;
				mat[nx][ny] = cur[2] + 1;
				queue.add(new int[] {nx, ny, cur[2] + 1});
			}
		}
		if(wcnt + count != N * M)
			max = 0;
		System.out.println(max - 1);
		br.close();
	}
}

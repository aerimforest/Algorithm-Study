import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dirx = {-1, 0, 1, 0};
		int[] diry = {0, -1, 0, 1};
		
		int[][] mat = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j) - '0';
			}
		}
		br.close();
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0, 0, 1});
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			if(cur[0]==N-1 && cur[1]==M-1) {
				System.out.println(cur[2]);
				return;
			}
			if(visit[cur[0]][cur[1]]) continue;
			visit[cur[0]][cur[1]] = true;
			
			for(int di=0; di<4; di++) {
				int nx = cur[0] + dirx[di];
				int ny = cur[1] + diry[di];
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(visit[nx][ny] || mat[nx][ny]==0) continue; 
				queue.add(new int[] {nx, ny, cur[2] + 1});
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int N, count;
	static int[][] arr;
	static boolean[][] visit;

	static int dirx[] = {-1,0,1,0};
	static int diry[] = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					count = 0;
					visit[i][j] = true;
					dfs(i, j);
					list.add(count);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i : list) {
			System.out.println(i);
		}
		
		br.close();
	}

	private static void dfs(int x, int y) {
		count++;
		for(int di=0; di<4; di++) {
			int nx = x + dirx[di];
			int ny = y + diry[di];
			
			if(nx<0|| ny<0|| nx>=N||ny>=N) continue;
			if(visit[nx][ny] || arr[nx][ny] == 0) continue;
			visit[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}

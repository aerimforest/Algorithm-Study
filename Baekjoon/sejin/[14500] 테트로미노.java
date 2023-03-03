import java.io.*;
import java.util.*;
 
public class Main {
 
    static int N,M;
	static int[][] arr;
	static int[] dx = {-1,1,0,0},dy={0,0,-1,1};
	static int MaxResult = 0, MaxValue = 0;
	static boolean[][] visited;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				MaxValue = Math.max(MaxValue, arr[i][j]);
			}
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				visited[i][j] = true;
				BFS(i,j,1,arr[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(MaxResult);
	}

	public static void BFS(int x, int y,int step, int sum){
		
		if(sum + (MaxValue)*(4-step) <= MaxResult) return;
		if(step == 4 ){
			MaxResult = Math.max(MaxResult, sum);
			return ;
		}

		for(int i=0;i<4;i++){
			int xx= x+dx[i];
			int yy = y+dy[i];

			if(xx<0 || xx>=N || yy<0 || yy>=M || visited[xx][yy]) continue;
			if(step==2){
				visited[xx][yy] = true;
				BFS(x,y,step+1,sum+arr[xx][yy]);
				visited[xx][yy] = false;
			}

			visited[xx][yy] = true;
			BFS(xx,yy,step+1,sum+arr[xx][yy]);
			visited[xx][yy] = false;
		}
	}

}

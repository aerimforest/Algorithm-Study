import java.io.*;
import java.util.*;
import java.awt.Point ;

// 3개의 방향으로 움직일 때 먹을 수 있는 최대의 사탕 수

public class Main {

	static int N,M;// 미로의 크기 
	static int[][] map, dist;
    static int[] dx = {1, 0, 1}, dy = {0, 1, 1};

	public static void main(String[] args) throws IOException {

		// 값 입력받기 -->
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		for(int i=0;i<N;i++)Arrays.fill(dist[i], Integer.MIN_VALUE);
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// <-- 
		BFS();
		System.out.println(dist[N-1][M-1]);
	} 
	public static void BFS(){
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0));
		dist[0][0] = map[0][0];

		while(!q.isEmpty()){
			Point now = q.poll();
			// System.out.println(now.x + " " + now.y);
			// System.out.println(Arrays.deepToString(dist));
			for(int i=0;i<3;i++){
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				if(xx<0 || xx>=N || yy<0 || yy>=M ) continue;
				if(dist[xx][yy] < dist[now.x][now.y] + map[xx][yy]){
					dist[xx][yy] = dist[now.x][now.y] + map[xx][yy];
					q.offer(new Point(xx,yy));
				}
			}
		}
	}


}


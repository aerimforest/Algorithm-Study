import java.io.*;
import java.util.*;
import java.awt.Point ;

// 미로 흰방 => 통과, 검은방 => +1
// BFS + 다익스트라
	// dist[][] 를 사용하여 검은방일 때 +1 

public class Main {

	static int N; 
	static int[][] map, dist;

	public static void main(String[] args) throws IOException {

		// 값 입력받기 -->
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];
		
		for(int i=0;i<N;i++){
			String now = br.readLine();
			for(int j=0;j<N;j++){
				map[i][j] = now.charAt(j)-'0';
			}
		}
		// <-- 

		for(int i=0;i<N;i++)Arrays.fill(dist[i],Integer.MAX_VALUE );

		BFS();
		System.out.println(dist[N-1][N-1]);
		System.out.println(Arrays.deepToString(dist));

	} 

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

	// BFS + 다익스트라
	public static void BFS(){
		dist[0][0] = 0 ;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0));

		while(!q.isEmpty()){
			Point now = q.poll();
			for(int i=0;i<4;i++){
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				if(xx<0 || xx>=N || yy<0 || yy>=N || dist[xx][yy] <= dist[now.x][now.y]) continue ;
				if(map[xx][yy] == 1) dist[xx][yy] = dist[now.x][now.y]; // 흰 방일 때 그대로
				else dist[xx][yy] = dist[now.x][now.y] + 1 ; // 검은방일 때 + 1
				q.offer(new Point(xx,yy));
			}
		}
	}
}

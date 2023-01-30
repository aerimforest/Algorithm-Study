import java.io.*;
import java.util.*;

// 문제 요약
// 동,서,남,북,상,하 이동 가능 (대각선 제외)

// 해결방법 ( 시간 1초, 1 ≤ L,R,C ≤ 30 )
// 완전탐색
// 2차원 -> 3차원
// 3차원 배열로 입력 int[][][] 
	// S => q . add (z , x , y ) , => 1
	// . => 0
	// # => 1
	// E => 100

// 동서남북상하 
// 동서남복상하 for(int i=0;i<6;i++){
// -1 1 0 0 0 0
// 0 0 1 -1 0 0
// 0 0 0 0 1 1
// }

// Point (z,x,y,time)
// time+1

class Point{
	int z,x,y, time;
	Point(int z, int x, int y, int time){
		this.z = z ;
		this.x = x ;
		this.y = y ;
		this.time = time;
	}
}


public class Main{

	static int Z,X,Y ; //층,행,열
	static int[][][] map ;
	static Queue<Point> q ;

	static StringTokenizer st;
	static StringBuilder sb ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		while(true){
			st = new StringTokenizer(br.readLine());
			Z = stoi(st.nextToken());
			X = stoi(st.nextToken());
			Y = stoi(st.nextToken());
			if(Z+X+Y == 0 ){
				System.out.println(sb.toString());
				break;
			}

			map = new int[Z][X][Y];
			q = new LinkedList();

			for(int i=0;i<Z;i++){
				for(int j=0;j<X;j++){
					char[] arr = br.readLine().toCharArray();
					for(int k=0;k<Y;k++){
						int now = 0 ;
						if(arr[k] == '#') now = 1 ;
						else if(arr[k] == 'S' ){
							q.add(new Point(i,j,k,0));
							now = 1 ;
						}else if(arr[k] == 'E') now = 100 ;
						map[i][j][k] = now;
					}
				}
				br.readLine();
			}

			BFS();
		}

	}

	static int[] dx = {-1,1,0,0,0,0}, dy = {0,0,1,-1,0,0}, dz={0,0,0,0,-1,1};

	public static void BFS(){
		while(!q.isEmpty()){
			
			Point now = q.poll();
			for(int i=0;i<6;i++){
				int zz = now.z + dz[i];
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];

				if(zz<0 || zz>=Z || xx<0 || xx>=X || yy<0 || yy>=Y ) continue;
				if(map[zz][xx][yy] == 100){ // E 라면
					sb.append("Escaped in " + (now.time+1) + " minute(s)." + "\n");
					return;
				}
				if(map[zz][xx][yy] == 0 ){
					map[zz][xx][yy] = 1 ;
					q.add(new Point(zz,xx,yy,(now.time+1)));
				}
			}
		}
		sb.append("Trapped!" + "\n");
	}
}

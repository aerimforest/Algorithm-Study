import java.util.*;
import java.io.*;

public class Main {
    
    static int minDistance = Integer.MAX_VALUE;
    static int[][] map ;
    static ArrayList<Point> edges = new ArrayList<>();
    static boolean[][] visited;
    static int N;
    static int LandNum = 1;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Point> que = new LinkedList<>();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

        FindLand();
        for(Point edge : edges){
            MakeBridge(edge.x, edge.y, map[edge.x][edge.y]);
        }
        
        System.out.println(minDistance);
    }

    public static void FindLand(){
        for (int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    DivideLand(i,j);
                    LandNum ++ ;
                }
            }
        }
    }

    public static void DivideLand(int x, int y){
        que.offer(new Point(x,y,0));
        visited[x][y] = true;
        
        while(!que.isEmpty()){
            Point now = que.poll();
            map[now.x][now.y] = LandNum;

            boolean FindEdge = false;
            for (int i=0;i<4;i++){
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if (xx <0 || xx>=N || yy<0 || yy>=N)continue;
                if(!FindEdge && map[xx][yy] == 0){
                    edges.add(now);
                    FindEdge = true;
                }
                
                if (map[xx][yy] == 1 && !visited[xx][yy]){
                    visited[xx][yy] = true;
                    que.offer(new Point(xx,yy,0));
                }
            }
        }
    }

    public static void MakeBridge(int x, int y, int NowNum){
        visited = new boolean[N][N];
        que = new LinkedList<>();
        que.offer(new Point(x,y,0));

        while(!que.isEmpty()){
            Point now = que.poll();
            if(now.dist >= minDistance) return;
            
            for (int i=0;i<4;i++){
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if (xx <0 || xx>=N || yy<0 || yy>=N)continue;
                if(map[xx][yy] != NowNum && map[xx][yy] != 0){
                    minDistance = Math.min(minDistance, now.dist);
                    return;
                }
                if (map[xx][yy] == 0 && !visited[xx][yy]){
                    visited[xx][yy] = true;
                    que.offer(new Point(xx,yy,now.dist+1));
                }
            }
        }   
    }

    static class Point{
        int x;
        int y;
        int dist;
        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}

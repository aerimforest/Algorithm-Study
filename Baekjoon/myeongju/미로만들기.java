import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int[][] dist;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j)-'0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(dist[N-1][N-1]);
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0,0));
        dist[0][0] = 0;

        while(!queue.isEmpty()){
            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if(nr>=0 && nr<N && nc>=0 && nc<N && dist[nr][nc] > dist[now.r][now.c]) {
                    if(map[nr][nc]==1) dist[nr][nc] = dist[now.r][now.c];
                    else dist[nr][nc] = dist[now.r][now.c] + 1;
                    queue.add(new Point(nr,nc));
                }
            }
        }
        
    }

    public static class Point{
        int r;
        int c;

        public Point(int r,int c) {
            this.r = r;
            this.c = c;
        }
    }
}

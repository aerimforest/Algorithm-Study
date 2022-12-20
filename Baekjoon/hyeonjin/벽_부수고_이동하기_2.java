import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        K = Integer.valueOf(str.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][K+1];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(getVisited());
    }

    private static int getVisited() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,1,0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.x == N - 1 && p.y == M - 1) return p.distance;

            for(int k = 0; k < 4; k++){
                int x = p.x + dx[k];
                int y = p.y + dy[k];


                if(x < 0 || x >= N || y < 0 || y >= M) continue;

                if(arr[x][y] == 0 && !visited[x][y][p.broken]){
                    visited[x][y][p.broken] = true;
                    queue.add(new Point(x,y,p.distance + 1, p.broken));
                }
                else if(p.broken < K && !visited[x][y][p.broken + 1]){
                    visited[x][y][p.broken + 1] = true;
                    queue.add(new Point(x,y,p.distance + 1, p.broken + 1));
                }
            }
        }
        return -1;
    }

    public static class Point{
        int x;
        int y;
        int distance;
        int broken;

        public Point(int x, int y, int distance, int broken){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.broken = broken;
        }
    }
}

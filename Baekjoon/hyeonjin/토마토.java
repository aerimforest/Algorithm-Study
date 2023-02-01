import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int M = Integer.valueOf(str.nextToken());
        int N = Integer.valueOf(str.nextToken());
        int[][] arr = new int[N][M];
        Queue<Point> tomato = new LinkedList<>();

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
                if(arr[i][j] == 1) tomato.add(new Point(i,j));
            }
        }

        while(!tomato.isEmpty()){
            Point point = tomato.poll();
            for(int i = 0; i < 4; i++){
                int x = point.x + dx[i];
                int y = point.y + dy[i];
                if(x < 0 || x >= N || y < 0 || y >= M || arr[x][y] != 0) continue;

                tomato.add(new Point(x,y));
                arr[x][y] = arr[point.x][point.y] + 1;
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        System.out.println(max - 1);
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

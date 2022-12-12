import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] check;
    static int max = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new int[N][M];
        check = new boolean[N][M];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
                if(arr[i][j] == 0) check[i][j] = true;
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!check[i][j]) {
                    count++;
                    findArea(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    private static void findArea(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));

        int area = 0;
        while(!queue.isEmpty()) {
            area++;
            Point target = queue.poll();
            for (int k = 0; k < 4; k++) {
                int xx = target.x + dx[k];
                int yy = target.y + dy[k];
                if (xx < 0 || xx >= N || yy < 0 || yy >= M || check[xx][yy]) continue;

                queue.add(new Point(xx, yy));
            }
        }

        max = Math.max(max, area);
    }

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            check[x][y] = true;
        }
    }
}

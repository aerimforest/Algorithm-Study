package SolveAc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class sa1194 {
    static int N;
    static int M;
    static char[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new char[N][M];

        Point start = new Point(0,0);
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == '0') start = new Point(i,j);
            }
        }

        go(start);
    }

    private static void go(Point start) {
        boolean[][][] check = new boolean[N][M][7];
        boolean[] key = new boolean[7];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        check[start.x][start.y][0] = true;

        int move = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point p = queue.poll();
                for(int k = 0; k < 4; k++){
                    int x = p.x + dx[k];
                    int y = p.y + dy[k];
                    if(x < 0 || x >= N || y < 0 || y >= M) continue;
                }
            }
        }
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

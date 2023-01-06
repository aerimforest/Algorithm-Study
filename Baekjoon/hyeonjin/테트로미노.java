import java.io.*;
import java.util.*;

public class 테트로미노 {
    static int[][] arr;
    static boolean[][] check;
    static int N;
    static int M;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new int[N][M];
        check = new boolean[N][M];

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                check[i][j] = true;
                dfs(1, i, j, arr[i][j]);
                check[i][j] = false;
            }
        }

        System.out.println(max);
    }




    private static void dfs(int depth, int x, int y, int value) {
        if(depth == 4){
            max = Math.max(value, max);
            return;
        }

        for(int k = 0; k < 4; k++){
            int xx = x + dx[k];
            int yy = y + dy[k];

            if(xx < 0 || xx >= N || yy < 0 || yy >= M || check[xx][yy]) continue;

            if(depth == 2){
                check[xx][yy] = true;
                dfs(depth + 1, x, y, value + arr[xx][yy]);
                check[xx][yy] = false;
            }

            check[xx][yy] = true;
            dfs(depth + 1, xx, yy, value + arr[xx][yy]);
            check[xx][yy] = false;
        }
    }
}

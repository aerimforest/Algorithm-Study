import java.io.*;
import java.util.*;

public class 주사위_굴리기 {
    static int N, M, X, Y, K;
    static int[][] arr;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[] dice = new int[7];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        X = Integer.valueOf(str.nextToken());
        Y = Integer.valueOf(str.nextToken());
        K = Integer.valueOf(str.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            int direct = Integer.valueOf(str.nextToken());
            int x = X + dx[direct];
            int y = Y + dy[direct];
            if(x < 0 || x >= N || y < 0 || y >= M) continue;

            move(direct, x, y);

            X = x;
            Y = y;
            bw.write(String.valueOf(dice[3]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static void move(int direct, int x, int y) {
        int tmp = dice[3];

        switch (direct){
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }

        if(arr[x][y] == 0) arr[x][y] = dice[6];
        else{
            dice[6] = arr[x][y];
            arr[x][y] = 0;
        }
    }
}

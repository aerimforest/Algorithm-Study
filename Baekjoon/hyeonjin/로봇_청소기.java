import java.io.*;
import java.util.*;

public class 로봇_청소기 {
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1 ,0};
    static int[] dy = {0, 1, 0, -1};
    static Point robot;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());

        str = new StringTokenizer(br.readLine());
        robot = new Point(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken()));
        arr = new int[N][M];
        for(int i = 0 ; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        clean();
    }

    private static void clean() {
        boolean stop = false;

        int count = 0;
        while(!stop){
            if(clear()) count++;
            if(checkClear()) continue;
            if(!checkBack()) stop = true;
        }

        System.out.println(count);
    }

    private static boolean checkBack() {
        int back = (robot.direct + 2) % 4;

        int x = robot.x + dx[back];
        int y = robot.y + dy[back];

        if(x < 0 || x >= N || y < 0 || y >= M || arr[x][y] == 1) return false;

        robot.x = x;
        robot.y = y;

        return true;
    }

    private static boolean checkClear() {
        for(int i = 0; i < 4; i++){
            //로봇 왼쪽으로 반향 전환
            robot.direct--;
            if(robot.direct < 0) robot.direct += 4;

            int x = robot.x + dx[robot.direct];
            int y = robot.y + dy[robot.direct];

            if(x < 0 || x >= N || y < 0 || y >= M || arr[x][y] == 1) continue;

            if(arr[x][y] == 0){
                robot.x = x;
                robot.y = y;
                return true;
            }
        }
        return false;
    }

    private static boolean clear() {
        if(arr[robot.x][robot.y] == 0) {
            arr[robot.x][robot.y] = 2;
            return true;
        }

        return false;
    }


    public static class Point{
        int x;
        int y;
        int direct;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int direct){
            this.x = x;
            this.y = y;
            this.direct = direct;
        }


    }
}

import java.io.*;
import java.util.*;

public class 말이_되고픈_원숭이 {
    static int K;
    static int W;
    static int H;
    static int[][] arr;
    static boolean[][][] check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[] horse_dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] horse_dy = {-1,1,-2,2,-2,2,-1,1};
    static int result = -1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        K = Integer.valueOf(br.readLine());

        str = new StringTokenizer(br.readLine());
        W = Integer.valueOf(str.nextToken());
        H = Integer.valueOf(str.nextToken());

        arr = new int[H][W];
        check = new boolean[H][W][K + 1];
        for(int i = 0; i < H; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        bfs();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0, K, 0));
        check[0][0][K] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(p.x == H - 1 && p.y == W - 1){
                result = p.count;
                return;
            }

            //말 점프를 안하는 경우
            for(int k = 0; k < 4; k++){
                int x = p.x + dx[k];
                int y = p.y + dy[k];

                if(x < 0 || x >= H || y < 0 || y >= W || check[x][y][p.horse] || arr[x][y] == 1) continue;

                queue.add(new Point(x,y,p.horse,p.count + 1));
                check[x][y][p.horse] = true;
            }

            //말 점프를 하는 경우
            if(p.horse == 0) continue;
            for(int k = 0; k < 8; k++){
                int x = p.x + horse_dx[k];
                int y = p.y + horse_dy[k];

                if(x < 0 || x >= H || y < 0 || y >= W || check[x][y][p.horse - 1] || arr[x][y] == 1) continue;

                queue.add(new Point(x,y,p.horse - 1,  p.count + 1));
                check[x][y][p.horse - 1] = true;
            }
        }
    }

    public static class Point{
        int x;
        int y;
        int horse;
        int count;

        public Point(int x, int y, int horse, int count) {
            this.x = x;
            this.y = y;
            this.horse = horse;
            this.count = count;
        }
    }
}

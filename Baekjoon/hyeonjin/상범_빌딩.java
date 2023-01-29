import java.io.*;
import java.util.*;

public class 상범_빌딩 {
    static int L;
    static int R;
    static int C;
    static char[][][] arr;
    static Point start;
    static Point end;
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,-1,0,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static boolean[][][] check;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        while(true) {
            str = new StringTokenizer(br.readLine());
            L = Integer.valueOf(str.nextToken());
            R = Integer.valueOf(str.nextToken());
            C = Integer.valueOf(str.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            result = -1;
            arr = new char[L][R][C];
            check = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        arr[i][j][k] = s.charAt(k);
                        if(arr[i][j][k] == 'S') start = new Point(i,j,k,0);
                        else if(arr[i][j][k] == 'E') end = new Point(i,j,k,0);
                    }
                }
                br.readLine();
            }

            bfs();

            if(result == -1) bw.write("Trapped!");
            else bw.write("Escaped in " + result + " minute(s).");
            bw.newLine();
        }
        bw.flush();
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        check[start.x][start.y][start.z] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int k = 0; k < 6; k++){
                int x = p.x + dx[k];
                int y = p.y + dy[k];
                int z = p.z + dz[k];

                if(x == end.x && y == end.y && z == end.z) {
                    result = p.time + 1;
                    return;
                }

                if(x < 0 || x >= L || y < 0 || y >= R || z < 0 || z >= C || check[x][y][z] || arr[x][y][z] == '#') continue;

                queue.add(new Point(x,y,z,p.time + 1));
                check[x][y][z] = true;
            }
        }
    }

    private static class Point{
        int x;
        int y;
        int z;
        int time;
        public Point(int x, int y, int z, int time){
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }
}

import java.io.*;
import java.util.*;

public class 확장_게임 {
    static int N;
    static int M;
    static int P;
    static int[] players;
    static char[][] arr;
    static boolean[][] visited;
    static Queue<Point>[] queue;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[] count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        P = Integer.valueOf(str.nextToken());

        players = new int[P + 1];
        queue = new Queue[P + 1];
        count = new int[P + 1];

        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= P; i++) {
            queue[i] = new LinkedList<>();
            players[i] = Integer.valueOf(str.nextToken());
        }

        arr = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] != '.') visited[i][j] = true;
                if(arr[i][j] >= '1' && arr[i][j] <= '9') {
                    queue[arr[i][j] - '0'].add(new Point(i,j));
                }
            }
        }

        while(!checkEnd()) {
            for(int i = 1; i <= P; i++) {
                go(i);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] >= '1' && arr[i][j] <= '9') {
                    count[arr[i][j] - '0']++;
                }
            }
        }

        for(int i = 1; i <= P; i++) {
            bw.write(count[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    private static void go(int player) {
        Queue<Point> q = queue[player];

        for(int p = 0; p < players[player]; p++) {
            int size = q.size();
            if(size == 0) return;

            for(int k = 0; k < size; k++) {
                Point point = q.poll();

                for(int z = 0; z < 4; z++) {
                    int x = point.x + dx[z];
                    int y = point.y + dy[z];

                    if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y]) continue;

                    q.add(new Point(x,y));
                    visited[x][y] = true;
                    arr[x][y] = (char)(player + '0');
                }
            }
        }
    }

    private static boolean checkEnd() {
        for(int i = 1; i <= P; i++) {
            if(!queue[i].isEmpty()) return false;
        }
        return true;
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}

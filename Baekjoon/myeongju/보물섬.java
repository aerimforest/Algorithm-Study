import java.util.*;
import java.io.*;

public class Main {

    static int R, C, answer;
    static char[][] map;
    static Queue<Point> q = new LinkedList<>();
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'L') {
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int r, int c) {
        int[][] v = new int[R][C];

        for(int i = 0; i< R; i++) {
            for(int j = 0; j < C; j++) {
                v[i][j] = -1;
            }
        }

        v[r][c] = 0;
        q.offer(new Point(r,c));

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int i = 0 ; i < 4 ; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(!check(nr,nc)) continue;

                if(map[nr][nc] == 'L' && v[nr][nc] == -1) {
                    v[nr][nc] = v[cur.r][cur.c] + 1;
                    q.offer(new Point(nr,nc));
                    answer = Math.max(answer, v[nr][nc]);
                }
            }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
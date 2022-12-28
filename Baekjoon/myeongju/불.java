import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int W,H;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    static Point start;
    static Queue<Point> fire;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H+2][W+2];
            v = new boolean[H+2][W+2];
            fire = new LinkedList<>();

            for (int i = 1; i <= H; i++) {
                String s = br.readLine();
                for (int j = 1; j <= W; j++) {
                    map[i][j] = s.charAt(j-1);
                    if(map[i][j]=='@')
                        start = new Point(i,j);
                    else if(map[i][j]=='*')
                        fire.add(new Point(i,j));
                }
            }
            sb.append(bfs()).append("\n");
        }

        System.out.println(sb);
    }

    public static String bfs() {
        String ans = "IMPOSSIBLE";
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        map[start.r][start.c] = '.';
        v[start.r][start.c] = true;
        int cnt = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            fire();
            for (int i = 0; i < size; i++) {
                Point now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = now.r+dr[d];
                    int nc = now.c+dc[d];
                    if(!check(nr,nc)) return cnt+"";
                    else if(!v[nr][nc] && map[nr][nc]=='.') {
                        v[nr][nc] = true;
                        queue.add(new Point(nr,nc));
                    }

                }
            }
            cnt++;
        }
        return ans;
    }

    public static void fire() {
        int size = fire.size();

        for (int i = 0; i < size; i++) {
            Point now = fire.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r+dr[d];
                int nc = now.c+dc[d];
                if(check(nr,nc) && map[nr][nc]=='.') {
                    fire.add(new Point(nr,nc));
                    map[nr][nc] = '*';
                }
            }
        }
    }

    public static boolean check(int r,int c) {
        return r>0 && r<=H && c>0 && c<=W;
    }

    public static class Point {
        int r;
        int c;
        public Point(int r,int c) { this.r=r; this.c=c;}
    }
}
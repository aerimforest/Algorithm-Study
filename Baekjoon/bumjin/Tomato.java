package baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {

    /**
     * 백준(7569) - 토마토(https://www.acmicpc.net/problem/7569)
     */
    private static Queue<Location> q = new LinkedList<>();
    private static int[][][] map;
    private static int[][][] time;
    private static int M, N, H;

    //위, 아래, 상, 우, 하, 좌
    private static int[] dz = {-1, 1, 0, 0, 0, 0};
    private static int[] dx = {0, 0, -1, 0, 1, 0};
    private static int[] dy = {0, 0, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        time = new int[H][N][M];

        int zeroCnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(reader.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    time[i][j][k] = -1;
                    if (map[i][j][k] == 0) {
                        zeroCnt++;
                    }

                    if (map[i][j][k] == 1) {
                        //시작점
                        time[i][j][k] = 0;
                        q.add(new Location(i, j, k));
                    }
                }
            }
        }

        if (zeroCnt == 0) {
            System.out.println(0);
            return;
        }

        bfs();

        zeroCnt = 0;
        int result = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        zeroCnt++;
                    }
                    result = Math.max(result, time[i][j][k]);
                }
            }
        }

        System.out.println(zeroCnt > 0 ? -1 : result);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Location l = q.poll();
            int qz = l.z;
            int qx = l.x;
            int qy = l.y;

            for (int i = 0; i < dx.length; i++) {
                int nz = qz + dz[i];
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M) {
                    continue;
                }

                if (map[nz][nx][ny] == 0 && time[nz][nx][ny] == -1) {
                    map[nz][nx][ny] = 1;
                    time[nz][nx][ny] = time[qz][qx][qy] + 1;
                    q.add(new Location(nz, nx, ny));
                }
            }
        }
    }

    static class Location {

        int z, x, y;

        public Location(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}

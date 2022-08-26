package Baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Illumination {

    /**
     * 백준(5547) - 일루미네이션(https://www.acmicpc.net/problem/5547)
     */
    private static int w, h;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[][] even = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private static int[][] odd = {{-1, 0}, {0, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        //벽면의 길이 구하기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h + 2][w + 2];
        visit = new boolean[h + 2][w + 2];

        for (int i = 1; i <= h; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(getSum());
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < 6; k++) {
                    int nx, ny;
                    if (i % 2 == 0) {
                        nx = i + even[k][0];
                        ny = j + even[k][1];
                    } else {
                        nx = i + odd[k][0];
                        ny = j + odd[k][1];
                    }
                    if (visit[nx][ny]) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    private static void bfs() {
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(0, 0));
        visit[0][0] = true;
        while (!q.isEmpty()) {
            Location l = q.poll();
            int lx = l.x;
            int ly = l.y;
            for (int i = 0; i < 6; i++) {
                int nx, ny;
                if (lx % 2 == 0) {
                    nx = lx + even[i][0];
                    ny = ly + even[i][1];
                } else {
                    nx = lx + odd[i][0];
                    ny = ly + odd[i][1];
                }

                if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) {
                    continue;
                }

                if (!visit[nx][ny] && map[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    q.add(new Location(nx, ny));
                }
            }
        }
    }

    static class Location {

        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

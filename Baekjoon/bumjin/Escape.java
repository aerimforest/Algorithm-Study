package Baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Escape {

    private static int r, c;
    private static char[][] map; // 고슴도치, 물 이동시 변경
    private static char[][] temp; // 입력한 값 그대로 보관
    private static int[][] time; // 이동 초 입력
    private static boolean[][] visit;

    private static Queue<Gosom> gosom = new LinkedList<Gosom>();

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static boolean flag = false;

    public static void main(String[] args) throws IOException {

        // 고슴도치 -> 비버 이동
        // 가능한 빨리 - bfs
        // r행c열
        // . : 비어있음
        // * : 물
        // X : 돌
        // S : 고슴도치
        // D : 비버

        // 1. 고슴도치 인접네칸 이동 : dx, dy - but, 돌(X), 물(*) 통과 불가능 || 물이 찰 예정인 칸 이동 불가능(?)
        // 2. 물 인접네칸 이동 : dx, dy - 물(*), 비어있음(.) 이동가능 - 돌(X), 비버소굴(D) 통과 불가능

        // 3. 다음 시간에 물이 찰 예정인 칸 움직일 수 없다. (물 큐를 먼저 수행)

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new char[r + 1][c + 1];
        temp = new char[r + 1][c + 1];
        time = new int[r + 1][c + 1];
        visit = new boolean[r + 1][c + 1];

        // 비버 굴 위치
        int x = 0;
        int y = 0;
        for (int i = 1; i <= r; i++) {
            char[] ch = reader.readLine().toCharArray();
            for (int j = 1; j <= c; j++) {
                map[i][j] = ch[j - 1];
                temp[i][j] = ch[j - 1];

                time[i][j] = -1;

                if (map[i][j] == '*') {
                    visit[i][j] = true;
                    time[i][j] = 0;
                    gosom.add(new Gosom(i, j));
                }

                if (map[i][j] == 'D') {
                    time[i][j] = -2;
                    x = i;
                    y = j;
                }
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (map[i][j] == 'S') {
                    visit[i][j] = true;
                    time[i][j] = 0;
                    gosom.add(new Gosom(i, j));
                }
            }
        }

        bfs();

        boolean flag = false;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (time[i][j] == -2) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            // 도달함
            System.out.print(time[x][y]);
        } else {
            // 도달못함
            System.out.print("KAKTUS");
        }

    }

    private static void bfs() {

        // 1. 고슴도치 인접네칸 이동 : dx, dy - but, 돌(X), 물(*) 통과 불가능 || 물이 찰 예정인 칸 이동 불가능(?)
        // 2. 물 인접네칸 이동 : dx, dy - 물(*), 비어있음(.) 이동가능 - 돌(X), 비버소굴(D) 통과 불가능

        while (!gosom.isEmpty()) {
            // 물 이동
            Gosom gs = gosom.remove();
            int x = gs.x;
            int y = gs.y;

            if (temp[x][y] == '*') {
                // 꺼낸게 물일때

                for (int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 1 || ny < 1 || nx > r || ny > c) {
                        continue;
                    }

                    if (!visit[nx][ny] && temp[nx][ny] == '.') {
                        visit[nx][ny] = true;
                        temp[nx][ny] = '*';
                        time[nx][ny] = time[x][y] + 1;
                        gosom.add(new Gosom(nx, ny));
                    }

                }
            }

            if (temp[x][y] == 'S') {
                // 꺼낸게 고슴도치일 때

                for (int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 1 || ny < 1 || nx > r || ny > c) {
                        continue;
                    }

                    if (!visit[nx][ny] && temp[nx][ny] == '.' || temp[nx][ny] == 'D') {
                        visit[nx][ny] = true;
                        temp[nx][ny] = 'S';
                        time[nx][ny] = time[x][y] + 1;
                        gosom.add(new Gosom(nx, ny));
                    }

                }
            }

        }

    }

    static class Gosom {

        int x, y;

        Gosom(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

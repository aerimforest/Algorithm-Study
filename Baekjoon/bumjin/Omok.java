package baekjoon.bumjin;

import java.io.IOException;
import java.util.Scanner;

public class Omok {

    /**
     * 백준(2615) - 오목(https://www.acmicpc.net/problem/2615)
     */
    private static int n = 19;
    private static int[][] map = new int[n][n];
    private static int[] dx = {-1, 0, 1, 1};//가장 왼쪽을 시작점으로 우상, 우, 우하, 하 탐색
    private static int[] dy = {1, 1, 1, 0};
    private static int result = 0;
    private static int row, col = -1;

    public static void main(String[] args) throws IOException {
        //검: 1, 흰: 2, 알x: 0
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    exploration(i, j);
                }
                if (result != 0) {
                    System.out.println(result);
                    System.out.println(row + " " + col);
                    return;
                }
            }
        }
        System.out.println(result);
    }

    private static void exploration(int x, int y) {
        boolean flag;
        for (int i = 0; i < dx.length; i++) {
            int nx = x;
            int ny = y;
            flag = true;
            for (int j = 0; j < 5; j++) {
                if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || map[x][y] != map[nx][ny]) {
                    flag = false;
                    break;
                }
                nx += dx[i];
                ny += dy[i];
            }
            if (flag) {
                if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || map[x][y] != map[nx][ny]) {
                    int qx = x - dx[i];
                    int qy = y - dy[i];
                    if (qx < 0 || qx >= 19 || qy < 0 || qy >= 19 || map[x][y] != map[qx][qy]) {
                        result = map[x][y];
                        row = x + 1;
                        col = y + 1;
                    }
                }
            }
        }
    }

}

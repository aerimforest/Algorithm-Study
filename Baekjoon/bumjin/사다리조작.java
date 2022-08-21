package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LadderManipulation {

    /**
     * 백준(15684) - 사다리 조작(https://www.acmicpc.net/problem/15684)
     */
    private static int N, M, H;
    private static boolean[][] map;
    private static boolean flag = false;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //본인 오른쪽 기준으로 넣기
            map[a][b] = true;
        }

        if (M == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i <= 3; i++) {
            flag = false;
            dfs(0, i);
            if (flag) {
                //자신 번호에 도달하면 단계 끝내기
                result = i;
                break;
            }
        }

        if (result > 3) {
            result = -1;
        }

        System.out.println(result);
    }

    private static void dfs(int count, int max) {
        if (flag) {
            return;
        }
        if (count == max) {
            if (move()) {
                flag = true;
            }
        } else {
            for (int i = 1; i <= H; i++) {
                for (int j = 1; j < N; j++) {
                    if (!map[i][j - 1] && !map[i][j] && !map[i][j + 1]) {
                        map[i][j] = true;
                        dfs(count + 1, max);
                        map[i][j] = false;
                    }
                }
            }
        }
    }

    private static boolean move() {
        for (int i = 1; i <= N; i++) {
            int col = i;
            int row = 1;
            while (row <= H) {
                if (map[row][col]) {
                    //->
                    col++;
                } else if (map[row][col - 1]) {
                    //<-
                    col--;
                }
                row++;
            }

            if (col != i) {
                //동일하게 종료되었는지 확인
                return false;
            }
        }
        return true;
    }
}

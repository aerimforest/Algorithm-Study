package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DragonCurve {

    /**
     * 백준(15685) - 드래곤 커브(https://www.acmicpc.net/problem/15685)
     */
    private static int[][] map;
    private static boolean[][] visit = new boolean[101][101];
    private static List<Integer> direction;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        //0세대 : 오른쪽(0)
        //1세대 : 시계방향으로 90도 회전(0, 1) 반대로 +1
        //2세대 : (0, 1, 2, 1) 반대로 +1
        //3세대 : (0, 1, 2, 1, 2, 3, 2, 1) 반대로 +1
        //규칙 : 앞 방향들에서 반대로 시작해 +1 하면 다음 세대가 된다.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        map = new int[n][4];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            direction = new ArrayList<>();
            direction.add(d);
            visit[y][x] = true;

            //이전 방향들의 반대로 +1 해주기
            reverseDir(g);

            //방향들 기준으로 이동
            //기존 x, y대로 넘기기
            move(y, x);
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visit[i][j] && visit[i + 1][j] && visit[i][j + 1] && visit[i + 1][j + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void move(int x, int y) {
        for (Integer integer : direction) {
            switch (integer) {
                case 0:
                    visit[x][++y] = true;
                    break;
                case 1:
                    visit[--x][y] = true;
                    break;
                case 2:
                    visit[x][--y] = true;
                    break;
                case 3:
                    visit[++x][y] = true;
                    break;
            }
        }
    }

    private static void reverseDir(int g) {
        for (int i = 0; i < g; i++) {
            for (int j = direction.size() - 1; j >= 0; j--) {
                switch (direction.get(j)) {
                    case 0:
                        direction.add(1);
                        break;
                    case 1:
                        direction.add(2);
                        break;
                    case 2:
                        direction.add(3);
                        break;
                    case 3:
                        direction.add(0);
                        break;
                }
            }
        }
    }
}

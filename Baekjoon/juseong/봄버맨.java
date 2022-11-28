import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int R, C, N;
    static char[][] A;
    static Queue<Bomb> bombs;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new char[R][];
        for (int i = 0; i < R; i++) {
            A[i] = br.readLine().toCharArray();
        }
    }

    static class Bomb {
        int x, y;

        public Bomb(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void find_bomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(A[i][j] == 'O') bombs.add(new Bomb(i, j));
            }
        }
    }

    static void boom() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] = 'O';
            }
        }
        while (!bombs.isEmpty()) {
            Bomb bomb = bombs.poll();
            int x = bomb.x, y = bomb.y;
            A[x][y] = '.';
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                A[nx][ny] = '.';
            }
        }
    }
    static void pro() {
        if (N % 2 == 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append('O');
                }
                sb.append('\n');
            }
        } else {
            bombs = new LinkedList<>();
            find_bomb();
            for (int sec = 3; sec <= N; sec+=2) {
                boom();
                find_bomb();
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(A[i][j]);
                }
                sb.append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}

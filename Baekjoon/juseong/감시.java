import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[][] board;
    static ArrayList<CCTV> cctv;
    static int[] dir;
    static boolean[][] view;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class CCTV {
        int x, y, num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static void search(int d, CCTV c) {
        if (d == 1) { // 위
            for (int i = 1; i < N; i++) {
                int nx = c.x - i;
                if (nx < 0) break;
                if (board[nx][c.y] == 6) break;
                view[nx][c.y] = true;
            }
        } else if (d == 2) { // 아래
            for (int i = 1; i < N; i++) {
                int nx = c.x + i;
                if (nx >= N) break;
                if (board[nx][c.y] == 6) break;
                view[nx][c.y] = true;
            }
        } else if (d == 3) { // 오
            for (int j = 1; j < M; j++) {
                int ny = c.y + j;
                if (ny >= M) break;
                if (board[c.x][ny] == 6) break;
                view[c.x][ny] = true;
            }
        } else if (d == 4) { // 왼
            for (int j = 1; j < M; j++) {
                int ny = c.y - j;
                if (ny < 0) break;
                if (board[c.x][ny] == 6) break;
                view[c.x][ny] = true;
            }
        }
    }

    static int calculation(int[] rotate) {
        view = new boolean[N][M];
        for (int k = 0; k < cctv.size(); k++) {
            CCTV c = cctv.get(k);
            if (c.num == 1) {
                if (rotate[k] == 0) { // 오
                    search(3, c);
                } else if (rotate[k] == 1) { // 아래
                    search(2, c);
                } else if (rotate[k] == 2) { // 왼
                    search(4, c);
                } else { //rotate[k] == 3, 위
                    search(1, c);
                }
            } else if (c.num == 2) {
                if (rotate[k] % 2 == 1) {
                    search(1, c);
                    search(2, c);
                } else {
                    search(3, c);
                    search(4, c);
                }
            } else if (c.num == 3) {
                if (rotate[k] == 0) { // 위, 오
                    search(1, c);
                    search(3, c);
                } else if (rotate[k] == 1) { // 오, 아래
                    search(3, c);
                    search(2, c);
                } else if (rotate[k] == 2) { // 아래, 왼
                    search(2, c);
                    search(4, c);
                } else { //rotate[k] == 3, 왼, 위
                    search(4, c);
                    search(1, c);
                }
            } else if (c.num == 4) {
                if (rotate[k] == 0) { // 왼 위 오
                    search(4, c);
                    search(1, c);
                    search(3, c);
                } else if (rotate[k] == 1) { // 위 오 아래
                    search(1, c);
                    search(3, c);
                    search(2, c);
                } else if (rotate[k] == 2) { // 오 아래 왼
                    search(3, c);
                    search(2, c);
                    search(4, c);
                } else { //rotate[k] == 3, 아래 왼 위
                    search(2, c);
                    search(4, c);
                    search(1, c);
                }
            }else if (c.num == 5) {
               search(1, c); // 위
               search(2, c); // 오
               search(3, c); // 아래
               search(4, c); // 왼
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!view[i][j] && board[i][j] == 0) count++;
            }
        }
        return count;
    }

    static void rec_func(int k) {
        if (k == cctv.size() ) {
            int count = calculation(dir);
            ans = Math.min(ans, count);
            return;
        }
        for (int i = 0; i < 4; i++) {
            dir[k] = i;
            rec_func(k + 1);
        }
    }

    static void pro() {
        cctv = new ArrayList<CCTV>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 6 && board[i][j] != 0) cctv.add(new CCTV(i, j, board[i][j]));
            }
        }
        dir = new int[cctv.size()];
        ans = Integer.MAX_VALUE;
        rec_func(0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}

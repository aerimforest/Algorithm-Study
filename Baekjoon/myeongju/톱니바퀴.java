import java.util.*;
import java.io.*;

public class Main {
    static int[][] wheel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheel = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = s.charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dire = Integer.parseInt(st.nextToken());
            check(num, dire);
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if (wheel[i][0] == 1)
                ans += Math.pow(2, i);
        }
        System.out.println(ans);
    }

    private static void check(int n, int d) {
        left(n - 1, -d);
        right(n + 1, -d);
        roll(n, d);
    }

    private static void left(int n, int d) {
        if (n < 0)
            return;
        if (wheel[n][2] != wheel[n + 1][6]) {
            left(n - 1, -d);
            roll(n, d);
        }
    }

    private static void right(int n, int d) {
        if (n > 3)
            return;
        if (wheel[n][6] != wheel[n - 1][2]) {
            right(n + 1, -d);
            roll(n, d);
        }
    }

    private static void roll(int n, int d) {
        if (d == 1) {
            int tmp = wheel[n][7];
            for (int i = 6; i >= 0; i--) {
                wheel[n][i + 1] = wheel[n][i];
            }
            wheel[n][0] = tmp;
        } else { // 반시계
            int tmp = wheel[n][0];
            for (int i = 1; i < 8; i++) {
                wheel[n][i - 1] = wheel[n][i];
            }
            wheel[n][7] = tmp;
        }
    }
}
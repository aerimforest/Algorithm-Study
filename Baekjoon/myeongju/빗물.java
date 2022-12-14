import java.util.*;
import java.io.*;

public class Main {

    static int H, W;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++)
                map[H - j - 1][i] = 1;
        }

        for (int i = 0; i < H; i++) {
            boolean wasBlack = false;
            int cnt = 0;
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    if (wasBlack) cnt++;
                } else {
                    if (wasBlack) {
                        answer += cnt;
                        cnt = 0;
                    } else
                        wasBlack = true;
                }
            }
        }

        System.out.println(answer);
    }
}
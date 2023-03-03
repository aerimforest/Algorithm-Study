import java.util.*;
import java.io.*;

class 게리맨더링_2 {
    static int N;
    static int[][] arr;
    static int total = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        N = Integer.valueOf(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
                total += arr[i][j];
            }
        }

        // solution
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;

                        getLand(x, y, d1, d2);
                    }
                }
            }
        }

        System.out.println(min);
    }

    private static void getLand(int x, int y, int d1, int d2) {
        boolean[][] land = new boolean[N][N];

        // 경계선 세팅
        for (int i = 0; i <= d1; i++) {
            land[x + i][y - i] = true;
            land[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            land[x + i][y + i] = true;
            land[x + d1 + i][y - d1 + i] = true;
        }

        int[] sum = new int[5];

        //1 구역
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (land[i][j]) break;
                sum[0] += arr[i][j];
            }
        }

        //2 구역
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (land[i][j]) break;
                sum[1] += arr[i][j];
            }
        }

        //3 구역
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (land[i][j]) break;
                sum[2] += arr[i][j];
            }
        }

        //4 구역
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (land[i][j]) break;
                sum[3] += arr[i][j];
            }
        }

        //5 구역
        sum[4] = total;
        for (int i = 0; i < 4; i++) {
            sum[4] -= sum[i];
        }

        Arrays.sort(sum);
        min = Math.min(min, sum[4] - sum[0]);
    }
}
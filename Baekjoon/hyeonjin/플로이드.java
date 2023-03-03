import java.io.*;
import java.util.*;

public class 플로이드 {
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) continue;

                arr[i][j] = 1_000_000_000;
            }
        }

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(str.nextToken());
            int b = Integer.valueOf(str.nextToken());
            int c = Integer.valueOf(str.nextToken());

            arr[a - 1][b - 1] = Math.min(arr[a - 1][b - 1], c);
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1_000_000_000) sb.append("0").append(" ");
                else sb.append(arr[i][j]).append(" ");
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
    }

    public static class Edge{
        int from;
        int to;
        int cost;

        public Edge(int x, int y, int z) {
            this.from = x;
            this.to = y;
            this.cost = z;
        }
    }
}

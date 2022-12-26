import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] list;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            list = new int[1000][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) list[0][i] = Integer.parseInt(st.nextToken());
            for (int i = 1; i < 1000; i++) {
                for (int j = 0, u = i - 1; j < n - 1; j++) {
                   list[i][j] =  Math.abs(list[u][j] - list[u][j+1]);
                }
                list[i][n-1] =  Math.abs(list[i-1][n-1] - list[i-1][0]);
            }
            boolean isZero = true;
            for (int j = 0; j < n; j++) {
                if (list[999][j] != 0) {
                    isZero = false;
                    break;
                }
            }
            if (isZero) {
                sb.append("ZERO").append("\n");
            } else {
                sb.append("LOOP").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}

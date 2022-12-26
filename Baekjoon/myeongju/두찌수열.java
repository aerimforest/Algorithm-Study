import java.util.*;
import java.io.*;

/*
N <= 1_000_000
1개 구매
원하는 만큼 판매
아무것도 안하기
 */
public class Main {

    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            for (int i = 0; i < N; i++)
                sum += arr[i] = Integer.parseInt(st.nextToken());

            int t = 0;
            String s = "LOOP";
            while (t++ < 1000) {
                if (sum == 0) {
                    s = "ZERO";
                    break;
                }
                sum = 0;
                int tmp = arr[0];
                for (int i = 0; i < N; i++) {
                    if (i < N - 1)
                        sum += arr[i] = Math.abs(arr[i + 1] - arr[i]);
                    else
                        sum += arr[i] = Math.abs(arr[i] - tmp);
                }
            }
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
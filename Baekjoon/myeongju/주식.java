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
    static int[] max;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            max = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++)
                max[i] = arr[i] = Integer.parseInt(st.nextToken());

            for (int i = N-2; i >= 0; i--) {
                if(max[i] < max[i+1]) max[i] = max[i+1];
            }

            long ans = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i] < max[i]) ans+= (max[i]-arr[i]);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
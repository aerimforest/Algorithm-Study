import java.util.*;
import java.io.*;

public class Main {

    static int M, N;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int r = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r,arr[i]);
        }

        int answer = 0;
        int l = 1;

        while (l <= r) {
            int cnt = 0;
            int mid = (l + r) / 2;
            for (int i = 0; i < N; i++) {
                cnt += arr[i] / mid;

                if (cnt > M) break;
            }

            if (cnt < M) {
                r = mid - 1;
            } else {
                l = mid + 1;
                answer = Math.max(mid, answer);
            }
        }

        System.out.println(answer);
    }
}

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        long answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long l = 0;
        long r = (long) M * arr[arr.length - 1];

        while (l <= r) {
            long mid = (r + l) / 2;

            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += mid / arr[i];

                if (cnt >= M) break;
            }

            if (cnt >= M) {
                answer = mid;
                r = mid - 1;
            } else l = mid + 1;
        }

        System.out.println(answer);
    }
}
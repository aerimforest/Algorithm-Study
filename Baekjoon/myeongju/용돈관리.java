import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        int max = 1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) max = arr[i];
        }

        System.out.print(search(max));
    }

    public static int search(int l) {
        int r = 10000_00000;
        int min = 10000;

        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            int money = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > money) {
                    cnt++;
                    money = mid;
                }
                money -= arr[i];
            }

            if (cnt <= M) {
                r = mid - 1;
                min = mid;
            } else {
                l = mid + 1;
            }
        }
        return min;
    }
}
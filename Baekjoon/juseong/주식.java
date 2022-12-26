import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long sum;
    static long[] nums;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sum = 0;
            long max = 0;
            N = Integer.parseInt(br.readLine());
            nums = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
            for (int i = N - 1; i >= 0; i--) {
                long num = nums[i];
                if (num > max) {
                    max = num;
                } else {
                    sum += (max - num);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb.toString());
    }
}

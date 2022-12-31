import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, x, ans;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[n+1];
        for (int i = 1; i <= n; i++) A[i] = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(br.readLine());
        // end of input
        Arrays.sort(A); // 오름차순 정렬
        int R = n, sum = 0;
        for (int L = 1; L < R; L++) {
            sum = A[L] + A[R]; // 양쪽 끝 수의 합

            // 가능한 R을 왼쪽으로 이동
            while (R - 1 > L && sum > x) {
                sum -= A[R];
                R--;
                sum += A[R];
            }

            if (sum == x) { // 정답 갱신
                ans++;
            }
        }
        System.out.println(ans);
    }
}

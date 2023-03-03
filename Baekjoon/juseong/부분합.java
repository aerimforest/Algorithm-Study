import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s, ans;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        A = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) A[i] = Integer.parseInt(st.nextToken());
        ans = n + 1;

        // 투포인터 시작
        int sum = 0, R = 0; // sum := [L ... R] 구간의 합
        for (int L = 1; L <= n; L++) {
            // [L ... R] 범위 안에 답이 존재한다
            sum -= A[L - 1]; // L-1 구간 제외

            // 가능한 오른쪽으로 이동
            while (R + 1 <= n && sum < s) {
                R++;
                sum += A[R];
            }

            // 정답 갱신
            if (sum >= s) {
                ans = Math.min(ans, R - L + 1);
            }
        }
        System.out.println(ans == n + 1 ? 0 : ans);
    }
}

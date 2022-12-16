import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 조카의 수
        n = Integer.parseInt(st.nextToken()); // 과자의 수
        A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
        pro();
    }

    static void pro() {
        // [L ... R] 범위 안에 정답이 존재한다
        // 이분탐색과 determination 문제를 이용해서 answer를 빠르게 구하자
        int L = 1, R = 1000000000, ans = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(int mid) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i] / mid;
            if (sum >= m) return true; // 과자의 수가 조카의 수 이상이면
        }
        return false;
    }
}

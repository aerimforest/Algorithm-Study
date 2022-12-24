import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[] day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 100,000
        M = Integer.parseInt(st.nextToken()); // 1 ≤ M ≤ N
        day = new int[N];
        for (int i = 0; i < N; i++) day[i] = Integer.parseInt(br.readLine()); // k(해당) 일에 사용할 금액
        // end of input
        int L = 1, R = 1000000000;
        while (L <= R) {
            // [L ... R] 범위 안에 정답이 있다
            // 인출할 최소 금액 구하기
            int mid = (L + R) / 2;
            if (determination(mid)) {
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(int mid) {
        int cnt = 0;
        int money = 0;
        for (int i = 0; i < N; i++) {
            if (day[i] > mid) return false; // i 일 사용 금액이 인출 금액보다 크면
            if (day[i] > money) { // i 일 사용금액이 현재 금액보다 크면
                money = mid; // 남은 금액을 넣고 통장에서 다시 인출
                cnt++; // 인출 횟수 증가
                money -= day[i]; // i 일 사용 금액만큼 돈 사용
            } else { // day[i] <= money
                money -= day[i]; // i 일 사용 금액만큼 돈 사용
            }
        }
        return cnt <= M; // 인출 횟수 <= M 이면 정확히 M번 인출 할 수 있다
    }
}

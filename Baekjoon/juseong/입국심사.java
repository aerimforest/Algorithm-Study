import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] gate;
    static long ans;
    static long max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 입국심사대의 개수 (1 ≤ N ≤ 100,000)
        M = Integer.parseInt(st.nextToken()); // 사람의 수 (1 ≤ M ≤ 1,000,000,000)
        gate = new long[N]; // k번째 심사대가 심사하는데 걸린 시간(1 ≤ Tk ≤ 10^9)
        for (int i = 0; i < N; i++) {
            gate[i] = Long.parseLong(br.readLine());
            max = Math.max(max, gate[i]);
        }
        // R = 사람수 * 입국 심사대에서 걸리는 최대 값
        long L = 0, R = M * max, mid = 0;
        while(L <= R) {
            // [L ... R] 범위 안에 답이 존재
            mid = (L + R) / 2; // 심사는 하는데 걸린 시간
            if (determination(mid)) { // 해당 시간에 심사가 가능하면
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(long mid) {
        long cnt = 0; // 심사 가능한 사람의 수
        for (int i = 0; i < gate.length; i++) { // 심사대
            cnt += mid / gate[i]; // 심사대 별 가능한 사람 수
        }
        return M <= cnt; // 사람의 수 <= 심사 가능한 사람의 수
    }
}

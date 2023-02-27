import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        A = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int R = 0, cnt = 1, kk = 0, ans = 0;
        for (int L = 1; L <= n; L++) {
            if (A[L-1] > 0 && A[L-1] % 2 == 1) { // L-1 번째 수가 0이 아니거나 홀수이면
                kk--; // 삭제한 수 감소
            } else {
                cnt--; // L-1 구간 삭제
            }

            // 가능한한 오른쪽으로 이동
            while (R + 1 <= n && kk <= k) {
                int next = A[R+1]; // 다음 수
                if (next % 2 == 1) { // 다음수가 홀수이면
                    if (kk + 1 <= k) { // 홀수를 삭제할 수 있으면
                        kk++; // 홀수 삭제
                    } else { // 삭제할 수 없으면
                        break;
                    }
                } else {
                    cnt++; // 연속 수의 개수 증가
                }
                R++; // 오른쪽으로 이동
            }

            if (ans < cnt) ans = cnt; // 정답 갱신
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}

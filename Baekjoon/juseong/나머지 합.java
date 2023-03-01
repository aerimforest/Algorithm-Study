import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int sum = 0;
        int[] cnt = new int[m];
        for (int i = 0; i < n; i++) {
            sum = (sum + A[i]) % m;
            cnt[sum]++;
        }
        long ans = cnt[0]; // 나머지가 0 인경우
        for (int i = 0; i < m; i++) {
            ans += (long) cnt[i] * (cnt[i] - 1) / 2; // 나머지가 같은 경우
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}

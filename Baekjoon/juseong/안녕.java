import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i][0] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i][1] = Integer.parseInt(st.nextToken());
        rec_func(0, 0, 0);
        System.out.println(ans);
    }

    static void rec_func(int index, int health, int value) {
        if (index == N) {
            ans = Math.max(ans, value);
            return;
        }
        if (health + A[index][0] < 100) {
            rec_func(index + 1, health + A[index][0], value + A[index][1]);
        }
        rec_func(index + 1, health, value);
    }
}

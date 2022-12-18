import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 1 <= N <= 5000
        A = new int[N]; // 입력 수열
        memo = new int[N]; // 해당(k) 번째로 끝나는 증가 부분 수열의 개수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1 <= Ai <= 5000
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); // 해당(k)번째 수 입력
            memo[i] = 1; // 자신의 부분 수열
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) { // 이전 수가 자신 보다 작으면 자신을 뒤에 붙인다
                    memo[i] += memo[j]; // 경우의 수 추가
                    memo[i] %= 998244353; // 나머지 연산

                }
            }
            sb.append(memo[i]).append(" "); // 답 추가
        }
        System.out.print(sb.toString());
    }
}

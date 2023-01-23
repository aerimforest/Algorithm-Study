import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static long[] memo;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        memo = new long[5001]; // 길이가 k인 올바른 문자열의 개수
        memo[0] = 1L; // 길이가 0인 올바은 문자열은 개수는 0 (dp를 사용하기 위해 1을 삽입)
        memo[2] = 1L; // 길이가 2인 올바은 문자열은 개수는 1
        for (int L = 4; L <= 5000; L += 2) { // 짝수
            for (int first = 0, second = L - 2; first < L; first +=2, second -= 2) {
                // memo[6] = (4)0 + (2)2 + (0)4
                // memo[6] = memo[0]*memo[4] + memo[2]*memo[2] + memo[4]*memo[0]
                memo[L] += memo[first] * memo[second]; // 올바른 괄호 문자열의 개수 계산
                memo[L] %= 1000000007; //  1,000,000,007로 나눈 나머지 계산
            }
        }
        T = Integer.parseInt(br.readLine()); // testcase
        for (int i = 0; i < T; i++) {
            sb.append(memo[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb.toString());
    }
}

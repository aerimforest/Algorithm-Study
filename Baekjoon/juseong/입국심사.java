import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람의 수, 1 ≤ N ≤ 100,000
        int M = Integer.parseInt(st.nextToken()); // 심사대의 수, 1 ≤ M ≤ 1,000,000,000
        int[] gate = new int[M]; // 심사대별 소요 시간
        for (int i = 0; i < M; i++) {
            gate[i] = Integer.parseInt(br.readLine());
        }
        // 모든 사람이 심사를 마치는데 걸리는 시간의 최솟값을 출력한다.
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[] A, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
        memo = new int[N+1];
        // | (왼쪽을 바라보는 금색 돌상의 개수) - (오른쪽을 바라보는 금색 돌상의 개수) | 의 최댓값을 구해야 한다
        // MAX((왼쪽 - 오른쪽), (오른쪽 - 왼쪽)) 이 답이다.
        // 왼쪽 = 1, 오른쪽 = 2
        // CASE1: 왼쪽 = 1, 오른쪽 = -1 일때
        int max = 0;
        for (int i = 1; i <= N; i++) { // 돌상
            int num = (A[i] == 1 ? 1 : -1); // 돌상을 1 or -1 로 변환
            memo[i] = Math.max(memo[i-1] + num, num); // i번째 돌상을 사용했을때의 최댓값
            max = Math.max(memo[i], max); // 최대값 갱신
        }
        ans = max; // CASE1 최대값 입력
        Arrays.fill(memo, 0); // 초기화
        max = 0; // 초기화
        // CASE2: 왼쪽 = -1, 오른쪽 = 1 일때
        for (int i = 1; i <= N; i++) { // 돌상
            int num = (A[i] == 1 ? -1 : 1); //돌상을 1 or -1 로 변환
            memo[i] = Math.max(memo[i-1] + num, num); // i번째 돌상을 사용했을때의 최댓값
            max = Math.max(memo[i], max); // 최대값 갱신
        }
        ans = Math.max(ans, max); // CASE1, CASE2 최대값 비교
        System.out.println(ans);
    }
}

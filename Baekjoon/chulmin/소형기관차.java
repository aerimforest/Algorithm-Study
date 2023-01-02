import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소형기관차 {

	// 각 배열마다 소형 수송차가 얼마나 많은 인원들을 찾을 수 있는지 본다.
	static int N, max, size;
	static int[] arr, sum;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	// 누적합 문제
	private static void pro() {
		dp = new int[4][N + 1];
		
		for(int i=1; i<=3; i++) {
			for(int j=i * size; j<=N; j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-size] + sum[j] - sum[j-size]);
			}
		}
		System.out.println(dp[3][N]);
	}
	
	// 입력
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N + 1];
		sum = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + arr[i];
		}
		size = Integer.parseInt(br.readLine());
		
		br.close();
	}
}

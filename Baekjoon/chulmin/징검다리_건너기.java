import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 징검다리_건너기 {
	//dp 문제
	// dp[i] = Math.min( 
	//				Math.min(dp[i-1] + arr[i-1][0]
	//						 , dp[i-2] + arr[i-2][0])
	//				, dp[i-2]+k
	//			);
	
	static int N , K;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dp[1][0] = 0;
		
		for(int i=1; i<N; i++) {
			dp[i+1][0] = Math.min(dp[i+1][0], dp[i][0] + arr[i][0]);
			dp[i+1][1] = Math.min(dp[i+1][1], dp[i][1] + arr[i][0]);
			
			if(i+2 <= N) {
				dp[i+2][0] = Math.min(dp[i+2][0], dp[i][0] + arr[i][1]);
				dp[i+2][1] = Math.min(dp[i+2][1], dp[i][1] + arr[i][1]);
			}
			if(i+3 <= N)
				dp[i+3][1] = Math.min(dp[i+3][1], dp[i][0] + K);
		}
		
		System.out.println(Math.min(dp[N][0], dp[N][1]));
		
//		for(int i=0; i<=N; i++) {
//			System.out.print(dp[i][0] + " ");
//		}System.out.println();
//		
//		for(int i=0; i<=N; i++) {
//			System.out.print(dp[i][1] + " ");
//		}System.out.println();
		
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][2];
		dp = new int[N+1][2];
		
		// dp[i][0] => 매우 큰 점프를 사용하지 않은 dp
		// dp[i][1] => 매우 큰 점프를 사용한 dp		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=N; i++) {
			Arrays.fill(dp[i], 5000 * (i+1));
		}
		br.close();
	}
}

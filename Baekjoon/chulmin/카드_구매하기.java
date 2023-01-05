import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드_구매하기 {
	// dp 문제 
	static int N;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
			}
		}
		// 최댓값은 1_000 * 10_000
		System.out.println(dp[N]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}

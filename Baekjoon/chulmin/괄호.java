import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// dp 문제
	static long[] dp;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		findDp();
		input();
		pro();
	}
	
	private static void input() throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		br.close();
		
	}
	private static void pro() {
		System.out.println(sb);
	}
	private static void findDp() {
		dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		
		//dp[i] = dp[i-2] * dp[0] + dp[i-4] * dp[2] +...
		for(int i = 4; i<=5000; i+=2) {
			for(int j=0; j<i; j+=2) {
				dp[i] += (dp[j] * dp[i - 2 -j]) % 1_000_000_007L;
				dp[i] %= 1_000_000_007L;
			}
		}
	}
}

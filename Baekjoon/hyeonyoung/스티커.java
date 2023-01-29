import java.io.*;
import java.util.*;

// BOJ_9465

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] scores = new int[2][n+1];
			for(int i = 0; i < 2; i++) {
				String[] line = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {
					scores[i][j+1] = Integer.parseInt(line[j]);
				}
			}
			
			int[][] dp = new int[2][n+1];
			int answer = 0;
			
			dp[0][1] = scores[0][1];
			dp[1][1] = scores[1][1];
			for(int j = 2; j <= n; j++) {
				dp[0][j] = Integer.max(dp[0][j-2], dp[1][j-2]);
				dp[0][j] = Integer.max(dp[0][j], dp[1][j-1]);
				dp[0][j] += scores[0][j];
				
				dp[1][j] = Integer.max(dp[0][j-2], dp[1][j-2]);
				dp[1][j] = Integer.max(dp[1][j], dp[0][j-1]);
				dp[1][j] += scores[1][j];
			}
			
			answer = Integer.max(dp[0][n], dp[1][n]);
			answer = Integer.max(answer, dp[0][n-1]);
			answer = Integer.max(answer, dp[1][n-1]);
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

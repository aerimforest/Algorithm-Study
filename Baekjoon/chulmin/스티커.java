import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9465 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int ti=1; ti<=T; ti++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			
			int arr[][] = new int[N][2];
			int dp[][] = new int[N][4];
			
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = arr[0][0];
			dp[0][2] = arr[0][1];
			dp[0][3] = Math.max(dp[0][1], dp[0][2]);
			
			for(int i=1; i<N; i++) {
				for(int j=0; j<2; j++) {
					dp[i][0] = dp[i-1][3];
					dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + arr[i][0];
					dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[i][1];
					dp[i][3] = Math.max(dp[i][1], dp[i][2]);
				}
			}
			
			sb.append(dp[N-1][3] +"\n");
		}
		System.out.println(sb);
		br.close();
	}
}

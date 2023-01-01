package ThisWeek21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배낭 문제
public class 안녕 {
	static int N;
	static int[] L, J;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		// 물건을 몇 개 고르는 지
		for(int i=1; i<=N; i++) {
			// 라이프를 얼마나 소모 가능한지
			for(int j=1; j<100; j++) {
				if(L[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-L[i]] + J[i]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][99]);
	}
	
	// 입력
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		L = new int[N+1];
		J = new int[N+1];
		// 100을 다 소모하면 죽는다.
		dp = new int[N+1][100];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}

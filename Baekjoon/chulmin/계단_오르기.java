import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단_오르기 {
	// dp 문제이다.
	// 한 계단을 밟았는지, 연속 두 계단을 밟았는지를 체크하면 된다.
	
	// dp[i][0] : 연속 한 계단을 밟았다. arr[i] + Math.max(dp[i-2][0], dp[i-2][1])
	// dp[i][1] : 연속 두 계단을 밟았다. arr[i] + dp[i-1][0];
	// dp[i][2] : 위의 두 식에 MAX가 쓰였으니 간단히 max를 여기에 저장한다.
	
	static int N, max;
	static int[] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	// dp계산하기
	private static void pro() {
		// dp 초기값
		dp[1][0] = arr[1];
		dp[1][2] = dp[1][0];
		
		for(int i=2; i<=N; i++) {
			dp[i][0] = arr[i] + dp[i-2][2];
			dp[i][1] = arr[i] + dp[i-1][0];
			dp[i][2] = Math.max(dp[i][0], dp[i][1]);
		}
		System.out.println(dp[N][2]);
	}

	// 입력을 받는다.
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		dp = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
	}
}

import java.io.*;
import java.util.*;

public class Main {

	// 문제 : 소형 기관차 3대를 이용하여 최대로 운송할 수 있는 손님 수

	static int N; // 기관차가 끌고 가던 객차의 수
	static int[] arr; // 객차에 타고 있는 손님의 수
	static int M; // 소형 기관차가 최대로 끌 수 있는 객차의 수

	static int[] sumArr; //손님의 수 누적합
	static int[][] dp; //dp[i][j] = i번째 소형 시관차가 객차 j번까지, 최대로 운동할 수 있는 손님 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		sumArr = new int[N+1];
		dp = new int[4][N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
			sumArr[i] = sumArr[i-1] + arr[i];
		}

		M = Integer.parseInt(br.readLine());

		for(int i=1;i<4;i++){
			for(int j=i*M;j<=N;j++){
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-M]+(sumArr[j]-sumArr[j-M]));
				
			}
		}
		System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[3][N]);
	}
}

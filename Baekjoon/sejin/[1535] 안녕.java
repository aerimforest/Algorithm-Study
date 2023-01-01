import java.io.*;
import java.util.*;

public class Main {

	static int N, healthIdx;
	static int[] HealthArr;
	static int[] HappyArr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		HealthArr = new int[N+1];
		HappyArr = new int[N+1];
		dp = new int[N+1][100];
		healthIdx = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			int nowH = Integer.parseInt(st.nextToken());
			HealthArr[i] = nowH;
			healthIdx = Math.min(healthIdx, nowH);
		}

		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			HappyArr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++){
			for(int j=healthIdx;j<=99;j++){
				if(HealthArr[i] <= j){
					dp[i][j] = Math.max(dp[i-1][j-HealthArr[i]]+HappyArr[i], dp[i-1][j]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		System.out.println(dp[N][99]);
	
	}
}

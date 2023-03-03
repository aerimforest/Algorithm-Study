import java.io.*;
import java.util.*;

// 문제 요약
// x%3 == 0 이면, 3으로 나눈다
// x%2 == 0 이면, 2로 나눈다
// 1로 뺀다
// 정수 N 을 위의 연산을 사용하여 1로 만들 때
	// 연산을 사용하는 횟수의 최솟값, 그 값들

// 해결방법 ( 시간제한 0.5초, 1 <= N <= 10^6 )
// DP
// 1부터 N까지 
// 1 2 3 4 5 6 7 8 9 10
// 0 1 1 2 3 2 3 3 2 3
// 4/2 = 2 + 자신의 연산 = DP
// N부터 -> 1 까지, 최솟값 -> 0 까지 비교

// 1 부터 시작해서 N 까지 갈 때 == k
// k%3 == 0 일 때, +1
// k%2 == 0 일 때, +1
// 둘 다 아니면 , +1 

public class Main{

	static int N; 
	static int[] dp ;
	static int[] ans ; 

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine()); // 정수 N
		dp = new int[N+1]; // 값 계산
		ans = new int[N+1]; // 경로 저장

		dp[1] = 0;

		for(int i=2;i<=N;i++ ){
			dp[i] = dp[i-1] + 1 ; // 둘 다 아닌경우 , 전 값 + 1 이므로
			ans[i] = i-1 ;
			if(i%3 == 0 && dp[i/3]+1 < dp[i]){
				dp[i] = dp[i/3]+1;
				ans[i] = i/3;
			}
			if(i%2 == 0 && dp[i/2]+1 < dp[i]){
				dp[i] = dp[i/2]+1;
				ans[i] = i/2;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(dp[N] + "\n");
		
		while(N>0){
			sb.append(N + " ");
			N = ans[N];
		}

		System.out.println(sb.toString());

	}
}

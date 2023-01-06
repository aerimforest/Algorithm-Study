import java.io.*;
import java.util.*;
 
public class Main {
 
    static int N;
	static int[] DayArr;
	static int[] moneyArr;
	static int[] dp;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(br.readLine());
		DayArr= new int[N];
		moneyArr = new int[N];
		dp = new int[N+1];

		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			DayArr[i] = day;
			int money = Integer.parseInt(st.nextToken());
			moneyArr[i] = money;
		}

		for(int i=0;i<N;i++){
			if(i+DayArr[i] <= N){
				dp[i+DayArr[i]] = Math.max(dp[i] + moneyArr[i],dp[i+DayArr[i]]);
			}
			dp[i+1] = Math.max(dp[i],dp[i+1]);
		}
		System.out.println(dp[N]);
	}
}


import java.io.*;
import java.util.*;
       
public class Main {

	static int N, K;
    static int[][] arr;
    static int[][] dp;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        arr = new int[N+4][2];
        dp = new int[N+4][2];
        for(int i=1;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());

        for(int i=0;i<N+4;i++) Arrays.fill(dp[i] , 1000000);

       dp[1][0] = 0; 

       for(int i=1;i<N;i++){
        
        dp[i+1][0] = Math.min(dp[i][0]+arr[i][0], dp[i+1][0]);
        dp[i+2][0] = Math.min(dp[i][0]+arr[i][1], dp[i+2][0]);
        dp[i+3][1] = Math.min(dp[i+2][1]+arr[i+2][0], dp[i+1][1]+arr[i+1][1]);
        dp[i+3][1] = Math.min(dp[i+3][1], dp[i][0]+K);

       }

        System.out.println(Math.min(dp[N][0],dp[N][1]));
	}
}


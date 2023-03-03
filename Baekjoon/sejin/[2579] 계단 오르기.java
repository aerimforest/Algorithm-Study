import java.util.*;
import java.io.*;

class Main{

	public static void main(String args[]) throws Exception{
        
        Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
        int[] arr = new int[N+1];
        for(int i=1;i<N+1;i++) arr[i] = sc.nextInt();
        int[] dp = new int[N+1];

        dp[1] = arr[1];
        if(N>=2) dp[2] = arr[1] + arr[2];
        for(int i=3;i<N+1;i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]+arr[i-1])+arr[i];
        }
        System.out.println(dp[N]);	
	}
}

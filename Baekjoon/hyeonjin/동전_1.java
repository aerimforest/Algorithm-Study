import java.io.*;
import java.util.*;

public class 동전_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());

        int[] dp = new int[K + 1];
        dp[0] = 1;
        for(int i = 0; i < N; i++){
            int num = Integer.valueOf(br.readLine());
            for(int j = num; j <= K; j++){
                dp[j] += dp[j - num];
            }
        }
        System.out.println(dp[K]);
    }
}

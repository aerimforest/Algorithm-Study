import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] += dp[j];
                    dp[i] %= 998244353;
                }
            }
            bw.write(dp[i] + " ");
        }
        bw.flush();
    }
}

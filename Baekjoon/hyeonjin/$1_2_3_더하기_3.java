import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.valueOf(br.readLine());
        int[] arr = new int[num];
        int max = 0;
        for(int i = 0; i < num; i++){
            arr[i] = Integer.valueOf(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long[] dp = new long[max + 1];
        if(max >= 1) dp[1] = 1;
        if(max >= 2) dp[2] = 2;
        if(max >= 3) dp[3] = 4;
        if(max > 3){
            for(int i = 4; i <= max; i++){
                dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1_000_000_009;
            }
        }

        for(int i = 0; i < num; i++){
            bw.write(String.valueOf(dp[arr[i]]));
            bw.newLine();
        }
        bw.flush();
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        int num = Integer.valueOf(br.readLine());
        int[] arr = new int[num];
        int[] dp = new int[num];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        for(int i = 0; i < num; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]) max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}

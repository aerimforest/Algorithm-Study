import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[] weight;
    static int[] value;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.valueOf(str.nextToken());
        int max = Integer.valueOf(str.nextToken());

        weight = new int[num + 1];
        value = new int[num + 1];
        dp = new int[num + 1][max + 1];

        for(int i = 1; i <= num; i++){
            str = new StringTokenizer(br.readLine());
            weight[i] = Integer.valueOf(str.nextToken());
            value[i] = Integer.valueOf(str.nextToken());
        }

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= max; j++){
                dp[i][j] = dp[i-1][j];
                if(j - weight[i] >= 0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
            }
        }

        System.out.println(dp[num][max]);
    }
}

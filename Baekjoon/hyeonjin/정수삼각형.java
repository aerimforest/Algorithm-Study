import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] triangle = new int[501][501];
    static int[][] dp = new int[501][501];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.valueOf(br.readLine());

        for(int i = 1; i <= size; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = triangle[1][1];
        if(size == 1) {
            bw.write(String.valueOf(dp[1][1]));
        }
        else {
            dp[2][1] = dp[1][1] + triangle[2][1];
            dp[2][2] = dp[1][1] + triangle[2][2];

            for (int i = 3; i <= size; i++) {
                for (int j = 1; j <= i; j++) {
                    //1번을 고를때 0은 어차피 비어있고, 맥스값 비교면서 음수가 포함되지 않으니 그냥 0번도 포함해서 계산해도됨
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }

            int max = 0;
            for(int i = 1; i <= size; i++){
                max = max < dp[size][i] ? dp[size][i] : max;
            }
            bw.write(String.valueOf(max));
        }

        bw.flush();
    }
}


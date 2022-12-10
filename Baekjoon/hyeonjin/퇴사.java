import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static List<Counsel> counsels;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        counsels = new ArrayList<>();
        dp = new int[N + 6];

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            counsels.add(new Counsel(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken())));
        }

        for(int i = N; i > 0; i--){
            Counsel counsel = counsels.get(i - 1);
            int day = i + counsel.day;
            if(day > N + 1) dp[i] = dp[i+1];
            else dp[i] = Math.max(dp[i + 1], dp[day] + counsel.value);
        }

        System.out.println(dp[1]);
    }


    public static class Counsel{
        int day;
        int value;
        public Counsel(int day, int value){
            this.day = day;
            this.value = value;
        }
    }
}

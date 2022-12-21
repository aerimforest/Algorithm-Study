import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp =new int[100]; // dp[i] : i이하의 체력을 사용했을 경우 중의 최대 행복
        int[] hp = new int[N];
        int[] joy = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            hp[i] = Integer.parseInt(st1.nextToken());
            joy[i] = Integer.parseInt(st2.nextToken());
        }

        // 0번부터 N번까지
        for (int i = 0; i < N; i++) {
            for (int j = 99; j >= hp[i] ; j--) {
                dp[j] = Math.max(dp[j-hp[i]] + joy[i], dp[j]);
            }
        }

        System.out.println(dp[99]);
    }
}
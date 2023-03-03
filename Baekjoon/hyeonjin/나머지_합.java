import java.io.*;
import java.util.*;

public class 나머지_합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());

        int sum = 0;
        long[] cnt = new long[M];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sum += Integer.valueOf(str.nextToken());
            sum %= M;
            cnt[sum]++;
        }

        long result = cnt[0];
        for(int i = 0; i < M; i++){
            result += cnt[i] * (cnt[i] - 1) / 2;
        }
        System.out.println(result);

    }
}

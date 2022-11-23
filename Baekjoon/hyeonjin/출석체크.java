import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken()) + 2;
        int K = Integer.valueOf(str.nextToken());
        int Q = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        boolean[] check = new boolean[N + 3];
        int[] sum = new int[N + 3];
        List<Integer> sleep = new ArrayList<>();
        int[] code = new int[Q];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            sleep.add(Integer.valueOf(str.nextToken()));
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++){
            code[i] = Integer.valueOf(str.nextToken());
        }

        for(int i = 0; i < Q; i++){
            int now = code[i];

            if(sleep.contains(now))
                continue;

            while(now <= N){
                if(!sleep.contains(now))
                    check[now] = true;
                now += code[i];
            }
        }


        for(int i = 3; i <= N; i++){
            sum[i] = sum[i-1];
            if(!check[i])
                sum[i]++;
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int S = Integer.valueOf(str.nextToken());
            int E = Integer.valueOf(str.nextToken());
            System.out.println(sum[E] - sum[S-1]);
        }
    }
}

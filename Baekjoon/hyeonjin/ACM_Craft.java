import java.io.*;
import java.util.*;

public class ACM_Craft {
    static int T, N, K;
    static int X, Y, W;
    static int[] time;
    static int[] dist;
    static List<Integer>[] map;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        T = Integer.valueOf(br.readLine());
        for(int t = 0; t < T; t++){
            str = new StringTokenizer(br.readLine());
            N = Integer.valueOf(str.nextToken());
            K = Integer.valueOf(str.nextToken());
            time = new int[N + 1];
            map = new List[N + 1];
            dp = new int[N + 1];
            dist = new int[N + 1];
            for(int i = 1; i <= N; i++){
                map[i] = new ArrayList<>();
            }

            str = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                time[i] = Integer.valueOf(str.nextToken());
            }

            for(int i = 0; i < K; i++){
                str = new StringTokenizer(br.readLine());
                X = Integer.valueOf(str.nextToken());
                Y = Integer.valueOf(str.nextToken());
                map[X].add(Y);
                dist[Y]++;
            }

            W = Integer.valueOf(br.readLine());

            bw.write(String.valueOf(topologySort()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static int topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(dist[i] == 0) {
                queue.add(i);
                dp[i] = time[i];
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int next : map[now]){
                dist[next]--;
                dp[next] = Math.max(dp[next], dp[now]);
                if(dist[next] == 0) {
                    queue.add(next);
                    dp[next] += time[next];

                    if(next == W){
                        return dp[next];
                    }
                }
            }
        }

        return time[W];
    }
}

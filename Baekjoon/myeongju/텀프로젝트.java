import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int cnt = 0;
    static int[] arr;
    static boolean[] v;
    static boolean[] finished;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            v = new boolean[N + 1];
            finished = new boolean[N + 1];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++)
                dfs(i);
            sb.append(N - cnt).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int now) {
        if (v[now]) return;

        v[now] = true;
        int next = arr[now];

        if (!v[next]) dfs(next);
        else {
            if (!finished[next]) {
                cnt++;
                for (int i = next; i != now; i = arr[i])
                    cnt++;
            }
        }
        finished[now] = true;
    }
}


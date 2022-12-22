import java.util.*;
import java.io.*;

/*
N <= 10000
M <= 10000
K <= 10_000_000
가장 적은 비용으로 모든 사람과 친구되기
 */
public class Main {
    static int N, M, K;
    static int[] money;
    static int[] parents;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        money = new int[N + 1];
        parents = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        int sum = 0 ;
        for (int i = 1; i <= N; i++) {
            if(parents[i] == i)
                sum += money[i];
        }

        if(sum <= K) System.out.print(sum);
        else System.out.print("Oh no");
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (money[rootA] > money[rootB])
                parents[rootA] = rootB;
            else
                parents[rootB] = rootA;
        }
    }

    public static int find(int a) {
        if (parents[a] == a) return a;

        return parents[a] = find(parents[a]);
    }
}
import java.util.*;
import java.io.*;

/*
n <= 500,000
m <= 1,000,000
 */
public class Main {
    static int N, M;
    static int[] parents;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!union(a, b)) {
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        if (rootA < rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
        return true;
    }

    public static int find(int a) {
        if (parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }
}
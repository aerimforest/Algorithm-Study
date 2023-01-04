import java.util.*;
import java.io.*;

/*
N <= 1,000,000
i가 속한 로봇 : robot(i)
서로 다른 부품 2개를 말해주며 같은 로봇의 부품임
i에 대해 robot(i)의 부품이 몇개인지 질문
 */
public class Main {
    static int N;
    static int[] parents;
    static int[] sum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[1_000_001];
        sum = new int[1_000_001];
        for (int i = 0; i <= 1_000_000; i++) {
            parents[i] = i;
            sum[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if (c == 'I') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else if (c == 'Q') {
                int a = Integer.parseInt(st.nextToken());
                sb.append(sum[find(a)]).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static int find(int a) {
        if (parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;
        if (rootA < rootB) {
            parents[rootB] = rootA;
            sum[rootA] += sum[rootB];
            sum[rootB] = 0;
        } else {
            parents[rootA] = rootB;
            sum[rootB] += sum[rootA];
            sum[rootA] = 0;
        }
    }
}
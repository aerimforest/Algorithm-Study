import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class KevinBacon {

    /**
     * 백준(1389) - 케빈 베이컨의 6단계 법칙(https://www.acmicpc.net/problem/1389)
     */
    private static List<Integer>[] list;
    private static int n, m;
    private static boolean[] visit;
    private static int[] bacon; //각 단계별 베이컨 수 넣기

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            list[a1].add(a2);
            list[a2].add(a1);
        }

        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(visit, false);
            bacon = new int[n + 1];

            visit[i] = true;
            dfs(i, 0);

            sum[i] = sum();
        }

        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (sum[i] < min) {
                index = i;
                min = sum[i];
            }
        }

        //번호가 가장 적은 사람
        System.out.println(index);
    }

    private static int sum() {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += bacon[i];
        }
        return num;
    }

    private static void dfs(int index, int level) {
        if (bacon[index] != 0) {
            //방문한적 있는 정점
            bacon[index] = Math.min(bacon[index], level);
        } else {
            //새로운 정점
            bacon[index] = level;
        }

        for (int i : list[index]) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i, level + 1);
                visit[i] = false;
            }
        }
    }
}

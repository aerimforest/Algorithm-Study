import java.util.*;
import java.io.*;

/*
다시 풀어보기
 */
public class Main {
    static int N, M;
    static int[] arr, indegree;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            indegree = new int[N + 1]; // i번팀보다 낮은 팀 갯수
            list = new ArrayList[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
            }
            list[N] = new ArrayList<>();

            // 5 4 3 2 1 이라면
            // 5 : 4 3 2 1
            // 4 : 3 2 1
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    list[arr[i]].add(arr[j]);
                    indegree[arr[j]]++;
                }
            }

            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                Integer a = Integer.parseInt(st.nextToken());
                Integer b = Integer.parseInt(st.nextToken());
                if (list[a].contains(b)) {
                    list[a].remove(b);
                    list[b].add(a);
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    list[b].remove(a);
                    list[a].add(b);
                    indegree[b]++;
                    indegree[a]--;
                }
            }

            sb.append(topologicalSort()).append("\n");
        }
        System.out.print(sb);
    }

    public static String topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1)
                return "?";

            int now = queue.poll();
            ans.append(now + " ");
            cnt++;

            for (int next : list[now]) {
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }
        if (cnt != N) return "IMPOSSIBLE";
        else return ans.toString();
    }
}
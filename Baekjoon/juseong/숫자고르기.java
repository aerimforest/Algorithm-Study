import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] A;
    static boolean[] visited;
    static ArrayList<Integer> ans, temp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) A[i] = Integer.parseInt(br.readLine());
    }

    static void pro() {
        ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            temp = new ArrayList<>();
            if (!visited[i]) dfs(i, i);
        }
        Collections.sort(ans);
        sb.append(ans.size()).append("\n");
        for (int i = 0; i < ans.size(); i++) sb.append(ans.get(i)).append("\n");
        System.out.print(sb.toString());
    }

    static void dfs(int n, int s) {
        // n := 방문 정점, s := 시작 정점
        visited[n] = true;
        temp.add(n);
        if (!visited[A[n]]) { // 방문하지 않은 정점이면
            dfs(A[n], s);
        } else if (A[n] == s) { // 처음에 방문했던 정점이면
            ans.addAll(temp);
        } else { // 방문 초기화
            for (int i = 0; i < temp.size(); i++) visited[temp.get(i)] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

}

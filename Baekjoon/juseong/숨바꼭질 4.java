import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, k, ans;
    static int[][] A;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs();
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append("\n");
        Stack<Integer> stack = new Stack<>();
        int p = k;
        while (p != prev[p]) {
            stack.push(p);
            p = prev[p];
        }
        stack.push(n);
        while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        System.out.println(sb.toString());
    }

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        prev = new int[100001];
        Q.add(n);
        visited[n] = true;
        prev[n] = n;
        int time = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int s = 0; s < size; s++) {
                int num = Q.poll();
                if (num == k) {
                    ans = time;
                    return;
                }
                int n1 = num * 2, n2 = num - 1, n3 = num + 1;
                if (n1 >= 0 && n1 <= 100000 && !visited[n1]) {
                    visited[n1] = true;
                    prev[n1] = num;
                    Q.add(n1);
                }
                if (n2 >= 0 && n2 <= 100000 && !visited[n2]) {
                    visited[n2] = true;
                    prev[n2] = num;
                    Q.add(n2);
                }
                if (n3 >= 0 && n3 <= 100000 && !visited[n3]) {
                    visited[n3] = true;
                    prev[n3] = num;
                    Q.add(n3);
                }
            }
            time++;
        }
    }
}

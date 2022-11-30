import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] dist;
    static boolean[] visit;
    static int[] dir = {2, -1, 1};

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        dist = new int[100001];
        visit = new boolean[100001];
    }

    static void bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        visit[start] = true;
        dist[start] = 0;
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for (int k = 0; k < 3; k++) {
                int next;
                if (k == 0) {
                    next = cur * dir[k];
                    if (next < 0 || next > 100000) continue;
                    if (visit[next]) continue;
                    visit[next] = true;
                    dist[next] = dist[cur];
                } else {
                    next = cur + dir[k];
                    if (next < 0 || next > 100000) continue;
                    if (visit[next]) continue;
                    visit[next] = true;
                    dist[next] = dist[cur] + 1;
                }
                Q.add(next);
            }
        }
    }

    static void pro() {
        bfs(N);
        System.out.println(dist[K]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}

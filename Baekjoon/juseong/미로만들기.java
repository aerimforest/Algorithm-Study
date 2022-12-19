import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int n;
    static String[] A;
    static int[][] dist;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new String[n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            A[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Dot> pq = new PriorityQueue<>();
        pq.add(new Dot(0, 0,0));
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            Dot dot = pq.poll();
            int x = dot.x, y = dot.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                int nd = (A[nx].charAt(ny) == '0') ? dot.d + 1 : dot.d;
                if (nd < dist[nx][ny]) {
                    dist[nx][ny] = nd;
                    pq.add(new Dot(nx, ny, nd));
                }
            }
        }
        System.out.println(dist[n-1][n-1]);
    }

    static class Dot implements Comparable<Dot> {
        int x, y, d;

        public Dot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Dot o) {
            return this.d - o.d;
        }
    }
}

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int ans = 0;
        boolean[] v = new boolean[N];

        v[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int t = 0; t < size; t++) {
                int now = queue.poll();

                if (now == N - 1) return ans;
                for (int i = 1; i <= arr[now]; i++) {
                    if (now+i<N && !v[now + i]) {
                        v[now + i] = true;
                        queue.add(now + i);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
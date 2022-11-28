import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, ans;
    static int[][] A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static class Class {
        int start, end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static void pro() {
        Arrays.sort(A, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        Queue<Class> Q = new LinkedList<>();
        Q.add(new Class(0, 0));
        for (int i = 0; i < n; i++) {
            int start = A[i][0];
            int end = A[i][1];
            if (!Q.isEmpty() && Q.peek().end <= start) {
                Q.poll();
                Q.add(new Class(start, end));
            } else {
                Q.add(new Class(start, end));
            }
            ans = Math.max(ans, Q.size());
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}

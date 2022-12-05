import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] == 2) continue;

            queue.add(i);
            if (queue.size() == K) {
                answer = Math.min(answer, i - queue.poll() + 1);
            }
        }

        System.out.println((answer < Integer.MAX_VALUE ? answer : -1));
    }
}
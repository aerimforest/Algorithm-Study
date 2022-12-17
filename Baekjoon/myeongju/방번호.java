import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static Node[] arr;
    static int[] list = new int[100];
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Node[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = new Node(i, Integer.parseInt(st.nextToken()));
            map.put(i, arr[i].p);
        }
        M = Integer.parseInt(br.readLine());

        // 가격 오름차순
        Arrays.sort(arr, ((o1, o2) -> o1.p - o2.p));

        int money = M;
        int cnt = 0;
        if (arr[0].n == 0) {
            if (N == 1 || arr[1].p > M) {
                System.out.println(0);
                return;
            }
            list[cnt++] = arr[1].n;
            money -= arr[1].p;
        }

        while (money >= arr[0].p) {
            list[cnt++] = arr[0].n;
            money -= arr[0].p;
        }


        for (int i = 0; i < cnt; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (i == 0 && j == 0) continue;
                int tmp = money + map.get(list[i]) - map.get(j);
                if (tmp >= 0) {
                    money = tmp;
                    list[i] = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append(list[i]);
        }

        System.out.print(sb);
    }

    public static class Node {
        int n;
        int p;

        public Node(int n, int p) {
            this.n = n;
            this.p = p;
        }
    }
}

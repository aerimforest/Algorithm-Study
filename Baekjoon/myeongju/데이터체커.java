import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Circle[] arr = new Circle[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arr[i] = new Circle(x - r, x + r);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.l != o2.l)
                return o1.l - o2.l;
            else return o1.r - o2.r;
        });

        boolean flag = true;

        for (int i = 1; i < N; i++) {

            if (arr[i - 1].r < arr[i].l) continue;
            if (arr[i - 1].l < arr[i].l && arr[i - 1].r > arr[i].r) continue;

            flag = false;
            break;
        }

        System.out.println((flag ? "YES" : "NO"));

    }

    public static class Circle {
        int l;
        int r;

        public Circle(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = 0, cnt = 0;
            while (idx < n) {
                if (cnt == a[i]) break;
                if (ans[idx] == 0)
                    cnt++;
                idx++;
            }
            if (ans[idx] != 0) {
                while (idx < n) {
                    idx++;
                    if (ans[idx] == 0) break;
                }
            }

            ans[idx] = i + 1;
        }

        for (int i = 0; i < n; i++)
            System.out.print(ans[i] + " ");
    }
}

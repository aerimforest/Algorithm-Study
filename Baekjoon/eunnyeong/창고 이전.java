import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int[] a = new int[n + 1];
        int[] b = new int[m + 1];

        for (int i = 1; i <= n; i++)
            a[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= m; i++)
            b[i] = Integer.parseInt(br.readLine());

        int sum = 0, cnt = 0, i = 1, j = 1;
        while (true) {
            if (b[j] > 0) {
                if (a[i] > 0) {
                    sum += i + j;
                    a[i]--;
                    b[j]--;
                    cnt++;

                }
                else
                    i++;
            }
            else
                j++;
            if (j > m || i > n) break;
        }
        System.out.print(cnt + " " + sum);
    }
}

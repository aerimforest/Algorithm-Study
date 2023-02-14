import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] a = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        double x = 0, y = 0;
        for (int i = 0; i < n - 1; i++) {
            x += a[i].x * a[i + 1].y;
            y += a[i].y * a[i + 1].x;
        }
        x += a[n - 1].x * a[0].y;
        y += a[n - 1].y * a[0].x;
        System.out.print(String.format("%.1f", (Math.abs(x - y) / 2.0)));
    }
    static class Point {
        long x, y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}

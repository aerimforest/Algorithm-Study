import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());

    int[] a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    Stack<Integer> s = new Stack<>();
    s.push(a[0]);
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    int cnt = 0, idx = 0;
    for (int i = 1; i < n; i++) {
      cnt++;
      if (s.peek() < a[i]) {
        s.push(a[i]);
        for (int j = idx; j <= cnt; j++)
          ans[j] = a[i];
        cnt = 0;
        idx = i;
      }
    }

    for (Integer i : ans)
      System.out.print(i + " ");
  }
}

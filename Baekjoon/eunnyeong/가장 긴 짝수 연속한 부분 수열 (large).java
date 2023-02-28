import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] s = new int[n];
    int ans = 0;
    for (int i = 0; i < n; i++) {
      s[i] = Integer.parseInt(st.nextToken());
      if (s[i] % 2 == 0) ans++;
    }

    int p1 = 0, p2 = 0, i = 0, cnt = 0;
    for (i = p1; i < n; i++) {
      if (s[i] % 2 != 0)
        cnt++;
      if (cnt > k) break;
    }
    p2 = i - 1;
    cnt--;

    System.out.println(ans);
    if (ans == 0) {
      System.out.print(ans);
      return;
    }

    ans = 0;
    while (true) {
      int x = p2 - p1 + 1 - cnt;
      ans = Math.max(ans, x);
      System.out.println(p1 + " " + p2 + " " + cnt);
      if (s[p1] % 2 != 0)
        cnt--;
      p1++;
      if (p1 >= n) break;
      if (s[p1] % 2 != 0) cnt++;
      //System.out.println(p1 + " " + p2 + " " + cnt);

        while (p2 < n) {
          if (s[p2] % 2 != 0) {
            if (cnt > k) {
              break;
            }
            cnt++;
          }
          p2++;
        }
        if (cnt > k) cnt--;
        if (p2 == n) p2--;
    }

    System.out.print(ans);
    bw.flush(); bw.close(); br.close();
  }
}

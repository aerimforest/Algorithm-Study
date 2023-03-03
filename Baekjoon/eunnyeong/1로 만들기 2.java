import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Check[] dp = new Check[n + 1];
    dp[1] = new Check(0, "1"); //1부터 역순으로 시작

    for (int i = 2; i <= n; i++) {
      int cnt = Integer.MAX_VALUE;
      int tmp = 0;

      if (i % 3 == 0) {
        cnt = dp[i / 3].n;
        tmp = i / 3;
      }

      if (i % 2 == 0) {
        if (cnt > dp[i / 2].n) {
          cnt = dp[i / 2].n;
          tmp = i / 2;
        }
      }

      if (cnt > dp[i - 1].n)
        tmp = n - 1;
      
      dp[i] = new Check(dp[tmp].n + 1, i + " " + dp[tmp].s);
    }

    bw.write(dp[n].n + "\n");
    bw.write(dp[n].s + "\n");
    bw.close(); br.close();
  }

  static class Check{
    int n;
    String s;

    public Check(int n, String s) {
      this.n = n;
      this.s = s;
    }
  }
}

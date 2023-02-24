import java.io.*;
import java.util.*;

public class Main {

  static int n, num;
  static int[] a;
  static List<Integer> ans;
  static boolean[] visit;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    a = new int[n + 1];
    for (int i = 1; i <= n; i++)
      a[i] = Integer.parseInt(br.readLine());

    visit = new boolean[n + 1];
    ans = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      visit[i] = true;
      num = i;
      dfs(i);
      visit[i] = false;
    }

    Collections.sort(ans);

    StringBuilder sb = new StringBuilder();
    sb.append(ans.size() + " \n");
    for (Integer i : ans)
      sb.append(i + "\n");

    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }

  public static void dfs(int x) {
    if (a[x] == num) ans.add(num); //시작했던 수와 a[x]가 같아진다면 결과에 담기

    if (!visit[a[x]]) {
      visit[a[x]] = true;
      dfs(a[x]);
      visit[a[x]] = false;
    }
  }
}

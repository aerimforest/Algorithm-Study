import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] a = new int[n + 1];
    int[] sum = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
      sum[i] = sum[i - 1] + a[i];
    }

    long cnt = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int i = 1; i <= n; i++) {
      cnt += map.getOrDefault(sum[i] - k, 0);
      map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
    }

    System.out.println(cnt);
  }
}

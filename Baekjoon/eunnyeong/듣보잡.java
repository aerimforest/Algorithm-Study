import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    PriorityQueue<String> ans = new PriorityQueue<>(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    });

    HashSet<String> a = new HashSet<>();

    int cnt = 0;
    for (int i = 0; i < n + m; i++) {
      String s = br.readLine();
      if(a.isEmpty() || !a.contains(s))
        a.add(s);
      else {
        cnt++;
        ans.add(s);
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(cnt + "\n");
    while(!ans.isEmpty())
      sb.append(ans.poll() + "\n");

    bw.write(sb.toString());
    bw.close(); br.close();
  }
}

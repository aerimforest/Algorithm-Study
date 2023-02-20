import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());

    for (int z = 0; z < tc; z++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      int[] a = new int[n + 1]; //건물 짓는데 걸리는 시간
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++)
        a[i] = Integer.parseInt(st.nextToken());

      LinkedList<Node> list = new LinkedList<>();
      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());
        list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      }

      int w = Integer.parseInt(br.readLine());

      int[] rslt = new int[n + 1];
      rslt[1] = a[1];
      for (int i = 0; i < list.size(); i++) {
        int x = rslt[list.get(i).tail];
        if (x != 0)
          rslt[list.get(i).tail] = Math.max(rslt[list.get(i).head] + a[list.get(i).tail], rslt[list.get(i).tail]);
        else
          rslt[list.get(i).tail] = a[list.get(i).tail];
      }
      System.out.println(rslt[w]);
    }
  }

  static class Node {
    int head, tail;
    public Node(int head, int tail) {
      this.head = head;
      this.tail = tail;
    }
  }
}

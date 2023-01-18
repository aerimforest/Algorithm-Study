import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    ArrayDeque<Point> a = new ArrayDeque<>(); //x: idx, y:height
    int[] b = new int[n]; //값 저장

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int top = Integer.parseInt(st.nextToken());
      if (a.isEmpty())
        a.push(new Point(i + 1, top));
      else {
        while(!a.isEmpty()) {
          if (a.peek().y > top) {
            b[i] = a.peek().x;
            a.push(new Point(i + 1, top));
            break;
          }
          else {
            a.pop();
            if(a.isEmpty()) {
              a.push(new Point(i + 1, top));
              break;
            }
          }
        }
      }
    }

    for (int i = 0; i < n; i++)
      System.out.print(b[i] + " ");
  }
}

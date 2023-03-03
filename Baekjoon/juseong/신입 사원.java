import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<People> peopleList;
    static int N;

    static class People implements Comparable<People>{
        int a, b;

        public People(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(People o) {
            return this.a - o.a;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            peopleList = new ArrayList<People>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                peopleList.add(new People(a, b));
            }
            Collections.sort(peopleList);

            int ans = 0, max = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (peopleList.get(i).b < max) {
                    ans++;
                    max = peopleList.get(i).b;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }
}

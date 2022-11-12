import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer>[] floor_list;
    static ArrayList<Integer>[] memo;
    static int ans;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        floor_list = new ArrayList[n];
        memo = new ArrayList[n];
        for (int i = 0; i < n; i++) floor_list[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) memo[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                floor_list[i].add(Integer.parseInt(st.nextToken()));
                memo[i].add(0);
            }
        }
    }

    static void pro() {
        memo[0].set(0, floor_list[0].get(0));
        for (int i = 1; i < n; i++) {
            memo[i].set(0, memo[i-1].get(0) + floor_list[i].get(0));
        }
        for (int i = 1; i < n; i++) {
            memo[i].set(i, memo[i-1].get(i-1) + floor_list[i].get(i));
        }
        for (int i = 1; i < n; i++) {
            for(int k = 1; k < i; k++) {
                int n = floor_list[i].get(k);
                int num = Math.max(memo[i-1].get(k-1)+n, memo[i-1].get(k)+n);
                memo[i].set(k, num);
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, memo[n-1].get(i));
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
       input();
       pro();
    }
}

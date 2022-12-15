import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] list;
    static long D, G;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (list[i].size() >= 3) {
                long n = list[i].size();
                G += n * (n - 1) * (n - 2) / 6;
            }
        }

        boolean[] v = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            long n = list[i].size() - 1;

            for (int j = 0; j < list[i].size(); j++) {
                if (v[list[i].get(j)]) continue;

                D += n * (list[list[i].get(j)].size() - 1);
            }
            v[i] = true;
        }

        if (D > G * 3) System.out.print("D");
        else if (D < G * 3) System.out.print("G");
        else System.out.print("DUDUDUNGA");
    }
}
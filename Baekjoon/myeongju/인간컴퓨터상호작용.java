import java.util.*;
import java.io.*;

public class Main {

    static String s;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int T = Integer.parseInt(br.readLine());
        arr = new int[26][s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            for (int j = 0; j < 26; j++) {
                arr[j][i] = arr[j][i - 1];
            }
            arr[c - 'a'][i]++;
        }

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(arr[a - 'a'][r + 1] - arr[a - 'a'][l]).append("\n");
        }

        System.out.print(sb);
    }
}
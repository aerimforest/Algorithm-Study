import java.util.*;
import java.io.*;

/*
 ArrayList Contains : O(n)
 HashSet Contains : O(1)
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> hs = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++)
            hs.add(br.readLine());

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (hs.contains(s)) list.add(s);
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (String s : list)
            System.out.println(s);
    }
}
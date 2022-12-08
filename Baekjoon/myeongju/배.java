import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[] crane;
    static List<Integer> box;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        crane = new int[N];

        for (int i = 0; i < N; i++)
            crane[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(crane);

        M = Integer.parseInt(br.readLine());

        box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++)
            box.add(Integer.parseInt(st.nextToken()));

        box.sort(Comparator.reverseOrder());

        System.out.println(move());
    }

    public static int move() {

        int time = 0;

        if(box.get(0) > crane[N-1]) return -1;

        while(!box.isEmpty()) {
            time++;

            int idx = 0;
            for (int i = N-1; i >= 0; i--) {

                while(box.size() > idx && box.get(idx) > crane[i])
                    idx++;

                if(box.size() <= idx) break;
                box.remove(idx);

                if(box.isEmpty()) break;
            }
        }

        return time;
    }

}
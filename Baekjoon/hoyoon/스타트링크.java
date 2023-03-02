import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스타트링크 {
    private static final String FAIL = "use the stairs";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] elevator = {U, -D};

        int cnt = 0;
        boolean isArrived = false;
        Queue<Integer> floors = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        floors.offer(S);

        LOOP:
        while (!floors.isEmpty()) {
            int size = floors.size();
            while (size-- > 0) {
                int floor = floors.poll();
                if (floor == G) {
                    isArrived = true;
                    break LOOP;
                }

                for (int button : elevator) {
                    int nextFloor = floor + button;
                    if (nextFloor <= 0 || F < nextFloor || !visit.add(nextFloor)) continue;
                    floors.offer(nextFloor);
                }
            }
            cnt++;
        }

        System.out.println(isArrived? cnt : FAIL);
        br.close();
    }
}

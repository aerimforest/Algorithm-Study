import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, k, ans;
    static int[] belt;
    static int[] robots;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[2*n];
        robots = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
    }

//    4. 내구도가 0인 칸의 개수 >= k 이면 종료, 그렇지 않으면 1번 과정으로 돌아가서 다시 반복한다.
    static boolean isEnd() {
        int zero = 0;
        for (int a: belt) {
            if (a == 0) zero++;
        }
        return zero >= k;
    }

    //  1. 밸트가 로봇과 함께 한칸 회전한다.
    //      - 내구도 칸 위치 + 1, 로봇 위치 + 1
    static void rotate() {
        // 밸트 이동
        int last = belt[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) belt[i] = belt[i - 1];
        belt[0] = last;

        // 로봇 이동
        for (int i = n - 1; i > 0; i--) robots[i] = robots[i - 1];
        robots[0] = 0;

        // n번칸(n-1) 로봇을 내린다.
        robots[n-1] = 0;

    }

    //  2. 가장 먼저 밸트에 올라간 로봇 부터, 회전하는 방향으로 이동할 수 있다면 이동한다.
    //      - 이동 조건: 이동하려는 칸에 로봇이 없고 내구도가 1이상 남아 있어야한다.
    static void move() {
        // 로봇 한칸 이동
        for (int i = n - 1; i > 0; i--) {
            if (robots[i - 1] == 1 && robots[i] == 0 && belt[i] >= 1) {
                robots[i] = robots[i - 1];
                robots[i - 1] = 0;
                belt[i]--;
            }
        }

        // n번칸(n-1) 로봇을 내린다.
        robots[n - 1] = 0;
    }

    // 3. 1번 위치의 칸의 내구도 >= 1 이면 1번에 로봇을 올린다. // 2번 과정으로 인해 2n번칸에는 로봇이 없다.
    static void add() {
        if (belt[0] >= 1) {
            robots[0] = 1;
            belt[0]--;
        }
    }

    /*
   1번: "올리는 위치",
    N번: "내리는 위치"

    로봇을 1개씩 1번에 올린다.
    n번에 도달하면 로봇을 즉시 내린다. -> 이동인 경우 n번칸 내구도를 1감소 후 로봇을 삭제한다.

    로봇은 스스로 이동할 수 있다.
    올리는 위치에 올리거나 이동 하면 내구도 1이 감소한다.

    몇 번째 단계가 진행중 이었는지?
    1번째 단계 부터 시작
     */
    static void pro() {
        while(!isEnd()) { // 4
            ans++;
            rotate(); // 1
            move(); // 2
            add(); // 3
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int A, B, ans;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        A = scan.nextInt();
        B = scan.nextInt();
        ans = -1;
        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        boolean[] visited = new boolean[1000000001];
        Queue<Move> Q = new LinkedList<>();
        Q.add(new Move(A, 1));
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int s = 0; s < size; s++) {
                Move move = Q.poll();
                long num = move.num;
                if (num == B) {
                    ans = move.move;
                    return;
                }
                long num1 = num * 10 + 1, num2 = num * 2;
                if (num1 < 1000000001 && !visited[(int) num1]) {
                    visited[(int) num1] = true;
                    Q.add(new Move(num1, move.move + 1));
                }
                if (num2 < 1000000001 && !visited[(int) num2]) {
                    visited[(int) num2] = true;
                    Q.add(new Move(num2, move.move + 1));
                }
            }
        }
    }

    static class Move {
        long num;
        int move;

        public Move(long num, int move) {
            this.num = num;
            this.move = move;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] A;

    static boolean input() throws IOException {
        String line = br.readLine();
        if (line.equals("end")) return false;
        A = line.toCharArray();
        return true;
    }

    static void pro() {
        int Xcount = 0; // X 수
        int Ocount = 0; // O 수
        int XBingo = 0; // X 빙고 수
        int OBingo = 0; // O 빙고 수

        for (int i = 0; i < 9; i++) {
            if (A[i] == 'X') Xcount++;
            if (A[i] == 'O') Ocount++;
        }

        // X 수가 O 수보다 같거나 1개 많아야한다.
        if (!(Ocount == Xcount || Ocount == Xcount - 1)) {
            sb.append("invalid").append('\n');
            return;
        }

        // 가로줄 빙고
        for (int i = 0; i < 3; i++) {
            int s = i * 3;
            if (A[s] == '.') continue;
            if (A[s] == A[s + 1] && A[s + 1] == A[s + 2]) {
                if (A[s] == 'X') XBingo++;
                else OBingo++;
            }
        }
        // 세로줄 빙고
        for (int i = 0; i < 3; i++) {
            if (A[i] == '.') continue;
            if (A[i] == A[i + 3] && A[i + 3] == A[i + 6]) {
                if (A[i] == 'X') XBingo++;
                else OBingo++;
            }
        }
        // 대각선줄 빙고
        if (A[0] != '.' && A[0] == A[4] && A[4] == A[8]) {
            if (A[0] == 'X') XBingo++;
            else OBingo++;
        }
        if (A[2] != '.' && A[2] == A[4] && A[4] == A[6]) {
            if (A[2] == 'X') XBingo++;
            else OBingo++;
        }

        int bingoCount = XBingo + OBingo; // 전체 빙고 수
        int round = Xcount + Ocount; // 글자 수

        if (bingoCount == 0) { // 빙고가 0개인 경우
            if (round == 9) { // 모든 칸에 글자가 적혀 있는 경우
                sb.append("valid").append('\n');
            } else {
                sb.append("invalid").append('\n');
            }
        } else if (bingoCount == 1) { // 빙고가 1개인 경우
            if ((round == 5 || round == 7) && XBingo == 1) { // X 빙고인 경우
                sb.append("valid").append('\n');
            } else if ((round == 6 || round == 8) && OBingo == 1) { // O 빙고인 경우
                sb.append("valid").append('\n');
            } else {
                sb.append("invalid").append('\n');
            }
        } else if (bingoCount == 2) { // 빙고가 2개인 경우
            // X가 마지막 가운데 하나를 둘 경우
            if (round == 9) sb.append("valid").append('\n');
            else sb.append("invalid").append('\n');
        }
        // 빙고는 3개이상 나오지 않는다. 위에서 X, O 의 개수로 가지치기를 했다.
    }

    public static void main(String[] args) throws IOException {
        while(input()) {
            pro();
        }
        System.out.println(sb.toString());
    }
}

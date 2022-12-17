import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        System.out.println(ccw(x1, y1, x2, y2, x3, y3));
    }

    public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        // 신발끈 공식을 이용하자
        // 세 점이 있을때 삼격형의 넓이를 구하는 방법
        int a = x1 * y2 + x2 * y3 + x3 * y1;
        int b = x2 * y1 + x3 * y2 + x1 * y3;

        // 반시계 방향
        if (a - b > 0) {
            return 1;
        } else if (a == b) { // 일직선
            return 0;
        } else { // 시계 방향
            return -1;
        }
    }

}

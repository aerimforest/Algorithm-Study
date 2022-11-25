import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int max;
    static int r1;
    static int c1;
    static int r2;
    static int c2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        r1 = Integer.valueOf(str.nextToken());
        c1 = Integer.valueOf(str.nextToken());
        r2 = Integer.valueOf(str.nextToken());
        c2 = Integer.valueOf(str.nextToken());

        max = Math.max(Math.abs(r1),Math.abs(c1));
        max = Math.max(Math.abs(max),Math.abs(r2));
        max = Math.max(Math.abs(max),Math.abs(c2));

        arr = new int[r2 - r1 + 1][c2 - c1 + 1];

        fill();
        print();
    }

    private static void fill() {
        int x = 0, y = 0, dir = 0;
        int num = 1, dnum = 1, cnt = 0;

        while (!isFinish()) {
            if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                arr[x - r1][y - c1] = num;
            }
            num++;
            cnt++;
            x = x + dx[dir];
            y = y + dy[dir];

            if (cnt == dnum) {
                cnt = 0;
                if (dir == 1 || dir == 3) dnum++;
                dir = (dir + 1) % 4;
            }
        }
        max = num - 1;
    }


    private static void print() {
        int maxLen = (int) Math.log10(max), len;

        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                len = maxLen - (int) Math.log10(arr[i][j]);
                for (int k = 0; k < len; k++) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isFinish() {
        return arr[0][0] != 0 && arr[r2 - r1][0] != 0 && arr[0][c2 - c1] != 0 && arr[r2 - r1][c2 - c1] != 0;
    }
}

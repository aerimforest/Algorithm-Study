import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int minX;
    static int minY;
    static int x;
    static int y;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        x = Integer.valueOf(str.nextToken());
        y = Integer.valueOf(str.nextToken());

        str = new StringTokenizer(br.readLine());
        int x2 = Integer.valueOf(str.nextToken());
        int y2 = Integer.valueOf(str.nextToken());
        int dx = Integer.valueOf(str.nextToken());
        int dy = Integer.valueOf(str.nextToken());

        if(dx != 0 && dy != 0) {
            int gcd = getGCD(dx, dy);
            dx /= gcd;
            dy /= gcd;
        }

        dfsPostive(x2,y2,dx,dy);
        dfsNegative(x2,y2,-dx,-dy);

        System.out.println(minX + " " + minY);
    }

    private static void dfsPostive(int xx, int yy, int dx, int dy) {
        if(xx <= 100 && xx >= -100 && yy <= 100 && yy >= -100){
            int distance = Math.abs(x - xx) + Math.abs(y - yy);

            if(distance < min){
                min = distance;
                minX = xx;
                minY = yy;
            }

            dfsPostive(xx + dx, yy + dy, dx, dy);
        }
    }

    private static void dfsNegative(int xx, int yy, int dx, int dy) {
        if(xx <= 100 && xx >= -100 && yy <= 100 && yy >= -100){
            int distance = Math.abs(x - xx) + Math.abs(y - yy);

            if(distance < min){
                min = distance;
                minX = xx;
                minY = yy;
            }
            dfsPostive(xx - dx, yy - dy, dx, dy);
        }
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
}

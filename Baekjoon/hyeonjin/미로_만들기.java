import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.valueOf(br.readLine());
        String str = br.readLine();

        char[][] arr = new char[101][101];
        for(char[] a : arr){
            Arrays.fill(a, '#');
        }

        int direct = 0;
        int x = 50;
        int y = 50;
        int x1 = 50;
        int y1 = 50;
        int x2 = 50;
        int y2 = 50;
        arr[x][y] = '.';

        for(int i = 0; i < num; i++){
            switch (str.charAt(i)){
                case 'R':
                    direct++;
                    break;
                case 'L':
                    direct--;
                    break;
                case 'F':
                    x += dx[direct];
                    y += dy[direct];
                    arr[x][y] = '.';

                    if(x < x1) x1 = x;
                    if(x > x2) x2 = x;
                    if(y < y1) y1 = y;
                    if(y > y2) y2 = y;

                    break;
            }

            if(direct < 0)
                direct = 3;
            if(direct == 4)
                direct = 0;
        }

        for(int i = x1; i <= x2; i++){
            String s = "";
            for(int j = y1; j <= y2; j++){
                s += arr[i][j];
            }
            System.out.println(s);
        }
    }
}

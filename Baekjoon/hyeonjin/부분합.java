import java.io.*;
import java.util.*;

public class 부분합 {
    static int N;
    static int S;
    static int[] sum;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        S = Integer.valueOf(str.nextToken());
        sum = new int[N + 1];

        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            sum[i] = sum[i - 1] + Integer.valueOf(str.nextToken());
        }

        twoPoint(0,1);

        if(min == Integer.MAX_VALUE) min = 0;
        System.out.println(min);
    }

    private static void twoPoint(int x, int y) {
        while (x < N && y <= N) {
            if(x == y){
                y++;
                continue;
            }

            if (sum[y] - sum[x] >= S) {
                min = Math.min(min, y - x);
                x++;
            }
            else y++;
        }

    }
}

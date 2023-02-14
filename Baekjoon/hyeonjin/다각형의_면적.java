import java.io.*;
import java.util.*;

public class 다각형의_면적 {
    static Axis[] axis;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        axis = new Axis[N + 1];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            long x = Integer.valueOf(str.nextToken());
            long y = Integer.valueOf(str.nextToken());

            axis[i] = new Axis(x,y);
        }
        axis[N] = axis[0];

        long sum1 = 0;
        long sum2 = 0;

        for(int i = 0; i < N; i++){
            sum1 += axis[i].x * axis[i + 1].y;
            sum2 += axis[i + 1].x * axis[i].y;
        }

        String result = String.format("%.1f", (Math.abs(sum1 - sum2) / 2.0));
        System.out.println(result);
    }

    public static class Axis{
        long x;
        long y;
        public Axis(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
}

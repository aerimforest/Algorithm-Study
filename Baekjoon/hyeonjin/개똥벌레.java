import java.io.*;
import java.util.*;

public class 개똥벌레 {
    static int N;
    static int H;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        H = Integer.valueOf(str.nextToken());

        int[] bottom = new int[H + 1];
        int[] up = new int[H + 1];

        int[] bottom_sum = new int[H + 2];
        int[] up_sum = new int[H + 2];

        for(int i = 1; i <= N; i++) {
            int num = Integer.valueOf(br.readLine());

            if(i%2 == 1) bottom[num]++;
            else up[num]++;
        }

        for(int i = 1; i <= H; i++) {
            up_sum[i] += up_sum[i - 1] + up[H - i + 1];
            bottom_sum[H - i + 1] += bottom_sum[H - i + 2] + bottom[H - i + 1];
        }

        int min = 200_000;
        int count = 0;
        for(int i = 1; i <= H; i++){
            int sum = up_sum[i] + bottom_sum[i];
            if(sum == min) {
                count++;
            }
            else if(sum < min) {
                min = sum;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }
}

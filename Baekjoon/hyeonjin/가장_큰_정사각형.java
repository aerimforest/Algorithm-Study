import java.io.*;
import java.util.*;

public class 가장_큰_정사각형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        int[][] arr = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j - 1));

                if(j == 1) arr[i][j] += arr[i-1][j];
                else arr[i][j] += arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1];
            }
        }

        int result = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                int k = 0;
                while(i + k <= N && j + k <= M) {
                    int num = arr[i + k][j + k] - arr[i - 1][j + k] - arr[i + k][j - 1] + arr[i - 1][j - 1];
                    if(num != Math.pow(k + 1, 2)) break;
                    result = Math.max(result, num);
                    k++;
                }
            }
        }

        System.out.print(result);
    }
}

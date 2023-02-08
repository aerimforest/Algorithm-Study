import java.io.*;
import java.util.*;

public class 사전 {
    static long[][] arr;
    static int N;
    static int M;
    static int K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        K = Integer.valueOf(str.nextToken());

        combi();
        String result = findString();
        System.out.println(result);
    }
    private static String findString() {
        StringBuffer sb = new StringBuffer();

        while(true) {
            //종료될때 체크
            if(N == 0) {
                //남은곳에 z 채우기
                for(int i = 0; i < M; i++) {
                    sb.append("z");
                }
                return sb.toString();
            }
            else if(K == 0) {
                for(int i = 0; i < N; i++) {
                    sb.append("a");
                }
                for(int j = 0; j < M; j++) {
                    sb.append("z");
                }

                return sb.toString();
            }
            else if(M < 0) {
                return "-1";
            }

            //a 문자 선택
            long num = arr[N + M][N - 1];
            if(num >= K){
                N--;
                sb.append("a");
            }
            //z 문자 선택
            else {
                K -= num;
                M--;
                sb.append("z");
            }
        }
    }

    private static void combi() {
        arr = new long[N + M + 1][N + M + 1];

        for(int i = 1; i <= N + M; i++) {
            arr[i][0] = 1;
            for(int j = 1; j <= i; j++) {
                arr[i][j] = (arr[i-1][j] + arr[i-1][j-1]) > Integer.MAX_VALUE? Integer.MAX_VALUE : arr[i-1][j] + arr[i-1][j-1];
            }
        }
    }
}

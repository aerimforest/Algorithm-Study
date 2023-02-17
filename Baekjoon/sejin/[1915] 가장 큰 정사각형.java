import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

    static int N,M;
    static int[][] arr ;
    static int[][] dp ;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        
        // 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // 맵 크기
        M = stoi(st.nextToken()); 

        arr = new int[N][M];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        // <-- 

        dp = new int[N+1][M+1];
        int ans = 0 ;
        dp[1][1] = arr[0][0];

        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(arr[i-1][j-1]==1){// 현재 1일 때
                    // 대각선, 왼쪽, 위 비교 , 최소한의 선분 + 자기자신 
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j] , dp[i][j-1]))+1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.println(ans*ans); // 정사각형
    }


}

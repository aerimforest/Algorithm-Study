import java.util.*;
import java.io.*;
 
// DP다 !  DP[N][M]
// N 이 주기, M 이 만족감
// 전 날 먹은 거 먹으면 1/2
// i = 디저트, j = 날짜
//DP르 구하는 2중 반복문 안에 또 반복문을 넣어서 구해야하는 부분에서 막힘

class Main {
    static int N , M ;
    static int[][] arr,dp;

    public static void main(String[] args) throws Exception {
        // 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 날짜
        M = Integer.parseInt(st.nextToken()); // 디저트
 
        arr = new int[M][N]; // 디저트 당 날짜 수
        dp = new int[N][M]; // 날짜 당 최대 만족감
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // <--
        for(int i=0;i<M;i++) dp[0][i] = arr[i][0]; // 첫째날 i 번 디저트
        // i = 날짜 , j = 디저트
        for(int i=1;i<N;i++){
            for(int j=0;j<M;j++){
                for(int k=0;k<M;k++){
                    if(k == j){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + (arr[j][i]/2));
                    }else{
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + arr[j][i]); // 자신의 값을 더해줘야 함 arr[j][i] ! arr[k][i] 로 해서 틀림
                    }
                }
            }
        }

        int ans = 0 ;
        for(int i=0;i<M;i++) ans = Math.max(ans, dp[N-1][i]);
        System.out.println(ans);

     }
}

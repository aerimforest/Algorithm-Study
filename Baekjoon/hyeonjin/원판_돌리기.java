import java.io.*;
import java.util.*;
public class 원판_돌리기 {
    static int N,M,T;
    static int circle[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        circle = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            rotate(x,d,k);
            erase();
        }

        int ans = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(circle[i][j] != -1) {
                    ans += circle[i][j];
                }
            }
        }
        System.out.println(ans);
    }

    public static void erase() {
        boolean check[][] = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(circle[i][j] == -1) continue;
                // 좌 우 체크
                int left = (j-1) > 0 ? j-1 : M;
                if(circle[i][j] == circle[i][left]) {
                    check[i][j] = true;
                    check[i][left] = true;
                }
                int right = (j+M+1)%M;
                if(circle[i][j] == circle[i][right]) {
                    check[i][j] = true;
                    check[i][right] = true;
                }
                // 상 하 체크
                int up = i+1;
                if(up<=N) {
                    if(circle[i][j] == circle[up][j]) {
                        check[i][j] = true;
                        check[up][j] = true;
                    }
                }
                int down = i-1;
                if(down > 0) {
                    if(circle[i][j] == circle[down][j]) {
                        check[i][j] = true;
                        check[down][j] = true;
                    }
                }
            }
        }

        boolean eraseFlag = false;
        int sum = 0;
        int cnt = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(check[i][j]) {
                    eraseFlag = true;
                    circle[i][j] = -1;
                }else {
                    if(circle[i][j] != -1) {
                        sum += circle[i][j];
                        cnt++;
                    }
                }
            }
        }
        if(eraseFlag) return;
        /* 삭제한 수가 없으면 */

        double avg = (double)sum/(double)cnt;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(circle[i][j] == -1) continue;

                if(circle[i][j] > avg ) {
                    circle[i][j] -= 1;
                }else if(circle[i][j] < avg){
                    circle[i][j] += 1;
                }
            }
        }
    }

    public static void rotate(int x, int d, int k) {
        int num = x;
        if(d == 0) {    // 시계 방향 회전
            while(num <= N) {
                int temp[] = new int[M+1];
                for(int i=1; i<=M; i++) {
                    int next = i+k > M ? i+k-M : i+k;
                    temp[next] = circle[num][i];
                }
                for(int i=1; i<=M; i++) {
                    circle[num][i] = temp[i];
                }
                num += x;
            }
        }else {    // 반시계 방향 회전
            while(num <= N) {
                int temp[] = new int[M+1];
                for(int i=M; i>=1; i--) {
                    int next = i-k > 0 ? i-k : i-k+M;
                    temp[next] = circle[num][i];
                }
                for(int i=1; i<=M; i++) {
                    circle[num][i] = temp[i];
                }
                num += x;
            }
        }
    }
}

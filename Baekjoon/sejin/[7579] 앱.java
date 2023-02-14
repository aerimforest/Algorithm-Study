import java.io.*;
import java.util.*;



public class Main {

    static int N, M; // 활성화 되어있는 앱의 수 , 필요한 메모리 
    static int[] memories ; // 각 앱의 메모리
    static int[] disabledCosts ; // 비활성화 비용
    static int[] dp ;

    public static int stoi(String num){
        return Integer.parseInt(num);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] mArr = br.readLine().split(" ");
        String[] costArr = br.readLine().split(" ");
        memories = new int[N];
        disabledCosts = new int[N];

        for(int i=0;i<N;i++){
            memories[i] = stoi(mArr[i]);
            disabledCosts[i] = stoi(costArr[i]);
        }
        int allCosts = Arrays.stream(disabledCosts).sum();
        dp = new int[allCosts+1]; 
        Arrays.fill(dp, -1);

        for(int i=0;i<N;i++){
            int cost = disabledCosts[i];
            for(int j=allCosts; j>=cost ; j--){
                if(dp[j-cost] != -1){
                    if(dp[j-cost] + memories[i] > dp[j]){
                        dp[j] = dp[j-cost]+ memories[i];
                    }
                }
            }
            if( dp[cost]<memories[i] ) dp[cost] = memories[i];
        }

        for(int i=0;i<10001;i++){
            if(dp[i]>=M){
                System.out.println(i);
                break;
            }
        }
    }

}

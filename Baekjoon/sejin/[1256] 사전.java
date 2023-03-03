import java.util.*;
import java.io.*;
 
class Main {
    static int N, M; // a 수, z 수
    static double K ;  // k번째 출력
    static double[][] dp= new double[101][101];
    static StringBuilder sb ;

    public static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = Double.parseDouble(st.nextToken());
        // <--

        sb = new StringBuilder();

        if(check(N,M) < K ) System.out.println( "-1" );
        else {
            makeS(N,M,K);
            System.out.println(sb.toString());
        }
        

    }
    
    // 재귀를 통해 점화식을 구함
    public static double check(int a , int z){
		if(a==0||z==0) return 1;
        if(dp[a][z] != 0 ) return dp[a][z] ;
        return dp[a][z] =  Double.min(check(a-1, z)+check(a, z-1), 1000000001);
    }

    public static void makeS(int a, int z , double k ){
        if( a == 0 ) {
            for(int i=0;i<z;i++) sb.append("z"); // 사용할 수 있는 a 가 없을 때 z 로 채워줌
            return ;
        }
        if( z == 0 ) {
            for(int i=0;i<a;i++) sb.append("a"); // 남은 a 만큼 !!!
            return;
        }

        double ck = check(a-1,z) ;
        if( ck >= k){ // a사용 가능
            sb.append("a");
            makeS(a-1,z,k);
        }else{
            sb.append("z");
            makeS(a,z-1,k-ck);
        }
        


    }


}


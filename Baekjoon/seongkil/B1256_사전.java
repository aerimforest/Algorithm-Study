package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1256_사전 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static double[][] dp;
    static int N, M;
    static double K;
    
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	K = scan.nextInt();
    }
    
    private static double check(int a,int z){
        if(a == 0 || z == 0)
            return 1;
        if(dp[a][z] != 0)
            return dp[a][z];
        return dp[a][z] = Double.min(check(a-1,z)+check(a,z-1),1000000001);
    }
    
    private static void pro(int a, int z, double k){
    	
    	dp = new double[N+1][M+1];
    	
    	
        if(a == 0){
            for(int i = 0;i < z;i++)
                sb.append("z");
            return;
        }
        if(z == 0){
            for(int i = 0;i < a;i++)
                sb.append("a");
            return;
        }

        double check = check(a - 1, z);

        if(k > check){
            sb.append("z");
            pro(a, z-1, k-check);
        }
        else{
            sb.append("a");
            pro(a-1,z,k);
        }
		
	}
    
    
    public static void main(String[] args) {
    	input();
    	pro(N, M, K);
    	
    	 if(check(N,M) < K)
             System.out.println(-1);
         else
             System.out.println(sb.toString());
    }
   
	

	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
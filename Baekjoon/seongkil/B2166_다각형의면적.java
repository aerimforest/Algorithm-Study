package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import fastCamp1.Sample.FastReader;

public class B2166_다각형의면적 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N;
    static int[][] arr;
    
    static void input() {
    	N = scan.nextInt();
    	arr = new int[N+1][2];
		for(int i=0; i<N; i++){
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
    }
    
    
    private static void pro() {
    	 arr[N][0] = arr[0][0];
         arr[N][1] = arr[0][1];
         
         long sum = 0;
         for (int i = 0; i < N; i++) {
             sum += 1l*arr[i][0]*arr[i+1][1] - 1l*arr[i+1][0]*arr[i][1];
         }
         sum = Math.abs(sum);
         System.out.printf("%.1f", 1d*sum/2);
		
	}
    
    
    public static void main(String[] args) {
    	input();
    	pro();
    	
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
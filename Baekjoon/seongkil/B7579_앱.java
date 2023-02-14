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

import fastCamp1.Sample.FastReader;

public class B7579_앱 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, M, ans;
    static int[][] Dy;
    static int[] memoryArr, costArr;
    
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	ans = Integer.MAX_VALUE;
    	
    	Dy = new int[N][100001];
    	memoryArr = new int[N];
    	costArr = new int[N];
    	
		for (int i = 0; i < N; i++) {
			memoryArr[i] = scan.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			costArr[i] = scan.nextInt();
		}
    }
    
    static void pro() { 
    	for (int i = 0; i < N; i++) {
    		for(int j = 0; j <= 10000; j++){            
                if(i == 0) {
                    if (j >= costArr[i]) Dy[i][j] = memoryArr[i];
                }
                else {
                    if (j >= costArr[i]) Dy[i][j] = Math.max(Dy[i - 1][j - costArr[i]] + memoryArr[i], Dy[i - 1][j]);
                    else Dy[i][j] = Dy[i - 1][j];
                }
    			
                if(Dy[i][j] >= M) ans = Math.min(ans, j);
            }
    	}
    }
    
    
    public static void main(String[] args) {
    	input();
    	pro();
    	System.out.println(ans);
    	    	
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
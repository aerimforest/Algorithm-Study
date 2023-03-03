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

public class B11404_플로이드 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static final int INF = 987654321;
    
    static int N, M;
    static int[][] arr;
    
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	
    	arr = new int[N+1][N+1];
    	
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			arr[i][j] = INF;
    			
    			if (i == j) {
    				arr[i][j] = 0;
    			}
    		}
    	}
    }
    
    
    public static void main(String[] args) {
    	input();
    	
    	for (int i = 0; i < M; i++) {
    		int a = scan.nextInt();
    		int b = scan.nextInt();
    		int c = scan.nextInt();
    		
    		arr[a][b] = Math.min(arr[a][b], c);
    	}
    	
    	for (int k = 1; k <= N; k++) {
    		for (int i = 1; i <= N; i++) {
    			for (int j = 1; j <= N; j++) {
    				if (arr[i][j] > arr[i][k] + arr[k][j]) {
    					arr[i][j] = arr[i][k] + arr[k][j];
    				}
    			}
    		}
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			if (arr[i][j] == INF) {
    				arr[i][j] = 0;
    			}
    			
    			sb.append(arr[i][j] + " ");
    		}
    		sb.append("\n");
    	}
    	
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
package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import Baekjoon.seongkil.Sample.FastReader;

public class B21940_가운데에서만나기 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, M, K;
    static final int INF = 987654321;
    static int[][] dist;
    static ArrayList<Integer> city;
    
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	
    	dist = new int[N + 1][N + 1];
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			dist[i][j] = INF;
    		}
    		dist[i][i] = 0;
    	}
    	
    	for (int i = 0; i < M; i++) {
    		int s = scan.nextInt();
    		int e = scan.nextInt();
    		int c = scan.nextInt();
    		if (dist[s][e] > c) {
    			dist[s][e] = c;
    		}
    	}
    	
    	K = scan.nextInt();
        city = new ArrayList<>();
        for (int i = 0; i < K; i++) {
             city.add(scan.nextInt());
         }    	
    }
    
    private static void pro() {	
    	 for(int l = 1; l <= N; l++) {
             for(int i = 1; i <= N; i++) {
                 for(int j = 1; j <= N; j++) {
                     if(dist[i][j] > dist[i][l] + dist[l][j]) dist[i][j] = dist[i][l] + dist[l][j];
                 }
             }
         }
  
         int[] max = new int[N + 1];
         int min = Integer.MAX_VALUE;
         for(int i = 1; i <= N; i++) {
             for(int j = 0; j < city.size(); j++) {
                 max[i] = Math.max(max[i], dist[city.get(j)][i] + dist[i][city.get(j)]);
             }
             min = Math.min(min, max[i]);
         }
  
         ArrayList<Integer> result = new ArrayList<>();
         for(int i = 1; i <= N; i++) {
             if(min >= max[i]) result.add(i);
         }
         Collections.sort(result);
  
         StringBuilder sb = new StringBuilder();
         for(int c : result) {
             sb.append(c + " ");
         }
         System.out.println(sb.toString());
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
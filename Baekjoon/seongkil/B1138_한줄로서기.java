package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1138_한줄로서기 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N;
    static int[] arr;
    
    static void input() {
    	N = scan.nextInt();
    	arr = new int[N+1];
    	
    	for (int i = 1; i <= N; i++) {
    		arr[i] = scan.nextInt();
    	}
    }
    
    private static void pro() {
    	List<Integer> ans = new ArrayList<>();
    	
    	for (int i = N; i >= 1; i--) {
    		ans.add(arr[i], i);
    	}
    	
    	for (int k : ans) {
    		System.out.print(k + " ");
    	}
		
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
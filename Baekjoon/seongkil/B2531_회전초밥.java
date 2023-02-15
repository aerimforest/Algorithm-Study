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

public class B2531_회전초밥 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, D, K, C, count;
    static int[] selected, dish;
    
    
    static void input() {
    	N = scan.nextInt();
    	D = scan.nextInt();
    	K = scan.nextInt();
    	C = scan.nextInt();
    	
    	dish = new int[N];
    	selected = new int[3001];
    	
    	for (int i = 0; i < N; i++) {
    		dish[i] = scan.nextInt();
    	}
    	
    	
    }
    
    private static void pro() {
		
    	for (int i = 0; i < K; i++) {
    		if (selected[dish[i]] == 0) {
    			count++;
    		}
    		selected[dish[i]]++;
    	}
    	
		int result = count;
		
		for (int i = 0; i < N; i++) {
			if (result <= count) {
				if (selected[C] == 0) result = count + 1;
				else result = count;
			}
			
			if (selected[dish[i]] == 1) count -= 1;
			selected[dish[i]]--;
			
			if (selected[dish[(i + K) % N]] == 0) count += 1;
			selected[dish[(i + K) % N]]++;
		}
    	
    	System.out.println(result);
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
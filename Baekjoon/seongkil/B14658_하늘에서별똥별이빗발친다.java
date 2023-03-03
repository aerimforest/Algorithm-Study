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

public class B14658_하늘에서별똥별이빗발친다 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, M, L, K;
    static List<int[]> stars;    
    
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	L = scan.nextInt();
    	K = scan.nextInt();
    	
    	stars = new ArrayList<>();
    	
    	for(int i = 0; i < K; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            stars.add(new int[]{x, y});
        }
    }
    
    private static int boundStar(int i, int j) {
        int res = 0;
        for (int[] s : stars) {
            if (i <= s[0] && s[0] <= i + L && j <= s[1] && s[1] <= j + L ) res++;
        }
        
        return res;
    }
    
    private static void pro() {
    	int res = Integer.MIN_VALUE;
        for (int[] s1: stars) {
            for (int[] s2: stars) {
                res = Math.max(res, boundStar(s1[0], s2[1]));
            }
        }
        System.out.println(K-res);
		
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
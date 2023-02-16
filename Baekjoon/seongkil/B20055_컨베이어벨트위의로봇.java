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

public class B20055_컨베이어벨트위의로봇 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    public static int N;
    public static int K;
    public static int[] A;
    public static boolean[] robot;
    
    static void input() {
    	N = scan.nextInt();
    	K = scan.nextInt();
    	A = new int[2*N];
    	robot = new boolean[N];
    	
    	for (int i = 0; i < A.length; i++) {
    		A[i] = scan.nextInt();
    	}
    }
    
    public static boolean isOK() {
        int cnt = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
    
    private static void pro() {
    	int cnt = 0;
    	while (isOK()) {
            int temp = A[A.length - 1]; 
            for (int i = A.length - 1; i > 0; i--) {
                A[i] = A[i - 1];
            }
            A[0] = temp;

            for (int i = robot.length - 1; i > 0; i--) {   
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            robot[N - 1] = false;
            for (int i = N - 1; i > 0; i--) {  
                if (robot[i - 1] && !robot[i] && A[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    A[i]--;
                }
            }

            if (A[0] > 0) {    
                robot[0] = true;
                A[0]--;
            }
            
            cnt++;
    	}
    	System.out.println(cnt);
		
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
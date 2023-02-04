package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sample {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    static int N, M, K;
    public static ArrayList<FireBall> list;
    public static Queue<FireBall>[][] grid; 
        
    static void input() {        	
    	N = scan.nextInt();
    	M = scan.nextInt();
    	K = scan.nextInt();
        
    	list = new ArrayList<>();
    	
        for (int i = 0; i < M; i++) {
            int r = scan.nextInt() - 1;
            int c = scan.nextInt() - 1;
            int m = scan.nextInt();
            int s = scan.nextInt();
            int d = scan.nextInt();
            list.add(new FireBall(r, c, m, d, s));
        }
        
        grid = new Queue[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = new LinkedList<>();

            }
        }    	
    }
    
    static void move() {
        for (FireBall f : list) {
            f.r = (N + f.r + dx[f.d] * (f.s % N)) % N;
            f.c = (N + f.c + dy[f.d] * (f.s % N)) % N;

            grid[f.r][f.c].add(f);
        }
    }
  
    static void combineAndDivide() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j].size() >= 2) {
                    int m_sum = 0, s_sum = 0;
                    int cnt_sum = grid[i][j].size();
                    boolean odd = true, even = true;

                    while (!grid[i][j].isEmpty()) {
                        FireBall f = grid[i][j].poll();
                        m_sum += f.m;
                        s_sum += f.s;

                        if (f.d % 2 == 0) {
                            odd = false;
                        } else {
                            even = false;
                        }
                        list.remove(f);
                    }

                    int nm = m_sum / 5;

                    if (nm == 0)
                        continue;

                    int ns = s_sum / cnt_sum;

                    if (odd | even) { 
                        for (int k = 0; k < 8; k += 2) { 
                            list.add(new FireBall(i, j, nm, k, ns));
                        }
                    } else {
                        for (int k = 1; k < 8; k += 2) { 
                            list.add(new FireBall(i, j, nm, k, ns));
                        }
                    }
                } else {
                    grid[i][j].clear();
                }
            }
        }
    }
   
    public static void main(String[] args) {
    	 input();
    	
		 while (K-- > 0) {
		     move();
		     combineAndDivide();
		 }
		
		 int answer = 0;
		 for (FireBall f : list) {
		     answer += f.m;
		 }
		 System.out.print(answer);
    	
    }
    
    static class FireBall {
	    int r, c, m, d, s;
	
	    public FireBall(int r, int c, int m, int d, int s) {
	        this.r = r; // 행
	        this.c = c; // 열
	        this.m = m; // 질량
	        this.d = d; // 방향
	        this.s = s; // 속력
	    }
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
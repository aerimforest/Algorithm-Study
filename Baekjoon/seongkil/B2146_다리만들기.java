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

public class B2146_다리만들기 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int N;
    private static int[] dr = new int[]{-1, 0, 1, 0};
    private static int[] dc = new int[]{0, -1, 0, 1};
    private static int landNum = 2; 
    private static int answer = Integer.MAX_VALUE; 
    
    static void input() {
    	N = scan.nextInt();
        map = new int[N][N];
        isVisited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }
    
    private static void makeLand(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        
        queue.offer(new Point(r, c, 0));
        isVisited[r][c] = true;
        map[r][c] = landNum;
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if ((r2 >= 0 && r2 < N && c2 >= 0 && c2 < N) && !isVisited[r2][c2] && map[r2][c2] == 1) {
                    isVisited[r2][c2] = true;
                    map[r2][c2] = landNum;
                    queue.offer(new Point(r2, c2, 0));
                }
            }
        }
        landNum++;
    }
   
    private static void bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<Point>();
        
        queue.offer(new Point(r, c, 0));
        int currentLandNum = map[r][c];
        isVisited[r][c] = true;
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if ((r2 >= 0 && r2 < N && c2 >= 0 && c2 < N) && !isVisited[r2][c2] && map[r2][c2] != currentLandNum) { 
                    isVisited[r2][c2] = true;
                    if (map[r2][c2] == 0) { 
                        queue.offer(new Point(r2, c2, point.cnt + 1));
                    } else { 
                        answer = Math.min(answer, point.cnt);
                    }
                }
            }
        }
    }
       
    private static void pro() {
    	for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1) { 
                    makeLand(r, c);
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] >= 2) {
                    isVisited = new boolean[N][N];
                    bfs(r, c);
                }
            }
        }
        System.out.println(answer);
		
	}
    
    public static void main(String[] args) {
    	input();
    	pro();  	    	
    }
   
    static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
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
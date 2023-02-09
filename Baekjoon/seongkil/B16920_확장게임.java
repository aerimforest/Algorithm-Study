package Baekjoon.seongkil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16920_확장게임 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    
    static int r, c, p;    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static int player[];
    static int[][] map;
    static Queue<Node> q[];
    
    static void input() {
    	r = scan.nextInt();
    	c = scan.nextInt();
    	p = scan.nextInt();
    	
    	player = new int[p+1];
    	map = new int[r][c];
		q = new LinkedList[p+1];
		
		for (int i = 1; i <= p; i++) {
			q[i] = new LinkedList<>();
		}
		
		for (int i = 1; i <= p; i++) {
			player[i] = scan.nextInt();
		}
		
		for (int i = 0; i < r; i++) {
			 String a  = scan.nextLine();
			 
			 for(int j = 0; j < a.length(); j++) {
				 char tmp = a.charAt(j);
				 if (tmp >= '1' && tmp <= '9') {
					 map[i][j] = tmp-'0';
					 q[map[i][j]].add(new Node(i,j));
				 } else if (tmp == '#') {
					 map[i][j] = -1;
				 }
					 
				 if (map[i][j] == '.') {
					 map[i][j] = 0;
				 }
			 }
		 }		
    }
    
    private static void pro() {
    	 boolean flag = false;
		 while (!flag) {
			 int cnt = 0;
			 for (int i = 1; i <= p; i++) {
				if (q[i].size() == 0)cnt++;
			 }
			 
			 if (cnt == p) {
				 flag = true;
				 break;
			 }
			 
			 for (int i = 1; i <= p; i++) {
				 for (int play = 0; play < player[i]; play++ ) {
				 	int qsize = q[i].size();
				 if (qsize == 0)break;
				 
				 while (qsize --> 0) {
					 Node cur = q[i].poll();
					 
					 for(int dir = 0; dir < 4; dir++) {
						 int nx = cur.x + dx[dir];
						 int ny = cur.y + dy[dir];
						 if(nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] == 0) {
							 map[nx][ny] = i;
							 q[i].add(new Node(nx,ny));
						 }
						 
					 }
				 }
				 }
				 	
			 }
		 }
    	
    	 int rst[] = new int[p+1];
		 for (int i = 0; i < r; i++) {
			 for (int j = 0; j < c; j++) {
				 if (map[i][j] >= 1 && map[i][j] <= 9)
					 rst[map[i][j]]++;
			 }
		 }
		 
		 for (int i = 1; i <= p; i++) {
			 System.out.print(rst[i]+" ");
		 }		 
		 
	}
       
    public static void main(String[] args) {
    	input();
    	pro();   	
    	    	
    }
   
    static class Node{
    	int x, y;

    	public Node(int x, int y) {
    		super();
    		this.x = x;
    		this.y = y;
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
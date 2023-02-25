package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14499_주사위굴리기 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int n,m,x,y,k;
    static int map[][];
    static int dx[] = {0,0,-1,1};
    static int dice[];
    static int dy[]  = {1,-1,0,0};
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Integer>direction = new ArrayList<>();
    
    static void input() {
    	String[] t = scan.nextLine().split(" ");
    	
    	  n = Integer.parseInt(t[0]);
          m = Integer.parseInt(t[1]);
          x = Integer.parseInt(t[2]);
          y = Integer.parseInt(t[3]);
          k = Integer.parseInt(t[4]);
          
          map = new int[n][m];
          dice = new int[7];
          
          for(int i=0; i<n; i++) {
              String[] input = scan.nextLine().split(" ");
              for(int j=0; j<input.length; j++) {
                  map[i][j]= Integer.parseInt(input[j]);
              }
          }
          
          String order[] = scan.nextLine().split(" ");
          
          for(int i=0; i<order.length; i++) {
              q.add(Integer.parseInt(order[i]));
          }
    	
    }
    
    public static void change_dice(int d) {
        int temp[] = new int[7];
        for(int i=1; i<=6; i++) {
            temp[i]=dice[i];
        }
        
        switch(d) {
	        case 1:    
	            dice[1]=temp[2];
	            dice[3]=temp[1];
	            dice[6]=temp[3];
	            dice[2]=temp[6];
	            break;
	        case 2:    
	            dice[1]=temp[3];
	            dice[2]=temp[1];
	            dice[6]=temp[2];
	            dice[3]=temp[6];
	            break;
	        case 3:    
	            dice[4]=temp[1];
	            dice[6]=temp[4];
	            dice[5]=temp[6];
	            dice[1]=temp[5];
	            break;
	        case 4:    
	            dice[5] = temp[1];
	            dice[6]=temp[5];
	            dice[4]=temp[6];
	            dice[1]=temp[4];
	            break;
        }
    }
    
    private static void pro() {
    	 while(!q.isEmpty()) {
             int d = q.poll();
             int nx = x+dx[d-1];
             int ny = y+dy[d-1];
             if(nx>=0 && ny>=0 && nx<n && ny<m) {
                 change_dice(d);
                 if(map[nx][ny]==0) {
                     map[nx][ny]=dice[6];
                 }
                 else {
                     dice[6]=map[nx][ny];
                     map[nx][ny]=0;
                 }
                 System.out.println(dice[1]);
                 x = nx;
                 y = ny;
             }
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
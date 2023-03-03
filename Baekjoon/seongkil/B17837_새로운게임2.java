import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static void input() {
    	N = scan.nextInt(); // 체스판 크기 
    	K = scan.nextInt(); // 말의 개수
    	
    	color = new int[N][N];
    	horse = new int[K][3];
    	map = new LinkedList[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			map[i][j] = new LinkedList<>();
    		}
    	}
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			color[i][j] = scan.nextInt();
    		}
    	}
    	
    	int x,y,d;
    	
    	for (int i = 0; i < K; i++) {
    		x = scan.nextInt() -1;
    		y = scan.nextInt() -1;
    		d = scan.nextInt();
    		
    		if (d == 1) d = 0;
    		else if (d == 4) d = 1;
    		
    		horse[i][0] = x;
    		horse[i][1] = y;
    		horse[i][2] = d;
    		
    		map[x][y].add(i);
    	}
    }
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, K; 
    static int color[][], horse[][];
    static LinkedList<Integer>[][] map;
    
    
    private static boolean move(int x, int y, int nx, int ny, int num, int order) {
		while (map[x][y].size() > num) {
			int temp = -1;
			if (order == 0)
				temp = map[x][y].remove(num);
			else
				temp = map[x][y].removeLast();
			horse[temp][0] = nx;
			horse[temp][1] = ny;
			map[nx][ny].add(temp);
		}
		
		if (map[nx][ny].size() >= 4)  
			return true;
	
		return false;
    }
    
    private static int searchOrder(int n, int x, int y) {
		for (int i = 0; i < map[x][y].size(); i++) {
			if (map[x][y].get(i) == n) {
				return i;
			}
		}
		return -1;
	}
    
    private static void pro() {
    	for (int t = 1; t <= 1000; t++) {
    		for (int k = 0; k < K; k++) {
    			int x = horse[k][0];
    			int y = horse[k][1];
    			int d = horse[k][2];
    			int num = searchOrder(k, x, y);
    		
    			int nx = x + dx[d];
    			int ny = y + dy[d];
    			
    			if (nx < 0 || nx >= N || ny < 0 || ny >= N || color[nx][ny] == 2) {
    				horse[k][2] = d = (d + 2) % 4;
    				nx = x + dx[d];
    				ny = y + dy[d];
    				
    				if (nx < 0 || nx >= N || ny < 0 || ny >= N || color[nx][ny] == 2)
    					continue;
    			}
    			
    			if (move(x, y, nx, ny, num, color[nx][ny])) {
    				System.out.println(t);
    				return;
    			}
    		}
    	}
    	System.out.println("-1");
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
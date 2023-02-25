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

public class B1063_킹 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dx = {1, -1, 0 , 0, 1, -1, 1, -1};
    
    static int ky, kx;
    static int sy, sx;
    static int N;
    
    static void input() {
    	String[] init = scan.nextLine().split(" ");
    	
    	kx = init[0].charAt(0) - 'A';
    	ky = init[0].charAt(1) - '0' - 1;
    	
    	sx = init[1].charAt(0) - 'A';
    	sy = init[1].charAt(1) - '0' -1;
    	
    	N = Integer.parseInt(init[2]);
    }
    
    static boolean check(int y, int x) {
    	if ( y < 0 || y >= 8 || x < 0 || x >= 8 ) {
    		return false;
    	}
    	return true;
    }
    
    static List<Integer> move(int y, int x, String o) {
    	int ny = 0, nx = 0;
    	List<Integer> pos = new ArrayList<Integer>();
    	switch (o) {
		    	case "R": 
    				ny = y + dy[0];
    				nx = x + dx[0];
    				break;
			    case "L": 
					ny = y + dy[1];
					nx = x + dx[1];
					break;
			    case "B": 
					ny = y + dy[2];
					nx = x + dx[2];
					break;
			    case "T": 
					ny = y + dy[3];
					nx = x + dx[3];
					break;
			    case "RT": 
					ny = y + dy[4];
					nx = x + dx[4];
					break;	
			    case "LT": 
					ny = y + dy[5];
					nx = x + dx[5];
					break;
			    case "RB": 
					ny = y + dy[6];
					nx = x + dx[6];
					break;
			    case "LB": 
					ny = y + dy[7];
					nx = x + dx[7];
					break;	
    	}
    	pos.add(ny);
    	pos.add(nx);
    	
    	return pos;
    }
    
    private static void pro() {
    	for (int i = 0; i < N; i++) {
    		String order = scan.next();
    		
    		List<Integer> pos = move(ky, kx, order);
    		if (!check(pos.get(0), pos.get(1))) continue;
    		
    		if (pos.get(0) == sy && pos.get(1) == sx) {
    			List<Integer> new_s = move(sy, sx, order);
    			if (check(new_s.get(0), new_s.get(1))) {
    				sy = new_s.get(0);
    				sx = new_s.get(1);
    				ky = pos.get(0);
    				kx = pos.get(1);
    			}
    		} else {
    			ky = pos.get(0);
    			kx = pos.get(1);
    		}
    	}
    	sb.append((char)(kx + 65)).append(ky+1).append("\n");
    	sb.append((char)(sx + 65)).append(sy+1).append("\n");
    	System.out.print(sb);
		
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
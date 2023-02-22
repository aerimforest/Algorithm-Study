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

public class B13335_트럭 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int n, w, L;
    static Queue<Integer> truck;
    
    static void input() {
    	n = scan.nextInt();
    	w = scan.nextInt();
    	L = scan.nextInt();
    	
    	truck = new LinkedList<Integer>();
    	for (int i = 0; i < n; i++) {
    		truck.offer(scan.nextInt());
    	}
    }
    
    private static void pro() {
    	int time = 0;
    	int bw = 0; 
    	Queue<Integer> q = new LinkedList<Integer>();
    	for (int i = 0; i < w; i++) {
    		q.add(0);
    	}
    	while (!q.isEmpty()) {
    		time++;
    		bw -= q.poll();
    		if (!truck.isEmpty()) {
    			if (truck.peek() + bw <= L) {
    				bw += truck.peek();
    				q.offer(truck.poll());
    			} else {
    				q.offer(0);
    			}
    		}
    	}
    		
    	System.out.println(time);
		
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
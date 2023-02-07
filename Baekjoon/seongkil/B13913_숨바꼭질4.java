package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B13913_숨바꼭질4 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    
    static void input() {
    	N = scan.nextInt();
    	K = scan.nextInt();
    	visited = new boolean[100001];
    	parent = new int[100001];
    }
    
    static int N, K;
    static boolean[] visited;
    static int[] parent;
    
    
    public static void main(String[] args) {
    	input();
    	
    	Queue<Position> q = new LinkedList<>();
    	q.offer(new Position(N, 0));
    	visited[N] = true;
    	
    	while (!q.isEmpty()) {
    		Position temp = q.poll();
    		
    		if (temp.current == K) {
    			System.out.println(temp.time);
    			
    			Stack<Integer> stack = new Stack<>();
    			int a = temp.current;
    			while (a != N) {
					stack.add(a);
					a = parent[a];
				}
    			
    			stack.add(a);
    			
    			while (!stack.isEmpty()) {
    				System.out.print(stack.pop() + " ");
    			}
    			
    			break;
    		}
    		
    		if (temp.current + 1 < 100001 && !visited[temp.current + 1]) {
    			q.offer(new Position(temp.current + 1, temp.time + 1));
    			visited[temp.current + 1] = true;
    			parent[temp.current + 1] = temp.current;
    		}
    		
    		if (temp.current - 1 >= 0  && !visited[temp.current - 1]) {
				q.offer(new Position(temp.current - 1, temp.time + 1));
				visited[temp.current - 1] = true;
				parent[temp.current - 1] = temp.current;
			}
			
			if (temp.current * 2 < 100001 && !visited[temp.current * 2]) {
				q.offer(new Position(temp.current * 2, temp.time + 1));
				visited[temp.current * 2] = true;
				parent[temp.current * 2] = temp.current;
			}
    	}
    	    	
    }
    
    static class Position {
    	int current;
    	int time;
    	
    	Position (int current, int time) {
    		this.current = current;
    		this.time = time;
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
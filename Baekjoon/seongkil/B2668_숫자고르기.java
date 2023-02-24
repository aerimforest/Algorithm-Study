package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2668_숫자고르기 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N;
    static ArrayList<Integer> list;
    static boolean[] visited;
    static int[] num;
    
    static void input() {
    	N = scan.nextInt();
    	num = new int[N+1];
    	for (int i = 1; i <= N; i++) {
    		num[i] = scan.nextInt();
    	}
    	
    	list = new ArrayList<>();
    	visited = new boolean[N+1];
    }
    
    private static void dfs(int start, int target) {
    	if (visited[num[start]] == false) {
    		visited[num[start]] = true;
    		dfs(num[start], target);
    		visited[num[start]] = false;
    	}
    	if (num[start] == target) {
    		list.add(target);
    	}
    }
    
    private static void pro() {
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
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
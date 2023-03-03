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

public class Main {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, M;
    static char[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[] keylist = { 'a', 'b', 'c', 'd', 'e', 'f' };
	static char[] doorlist = { 'A', 'B', 'C', 'D', 'E', 'F' };
	
	static PointM start;

    
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	map = new char[N][M];
    	visited = new boolean[N][M][64];
    	
		for (int i = 0; i < N; i++) {
			String s = scan.next();
			map[i] = s.toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '0') {
					start = new PointM(i, j, 0, 0);
					map[i][j] = '.';
				}
			}
		}
    }
    
    private static int index_of_key(char key) {
		for (int i = 0; i < 6; i++)
			if (key == keylist[i])
				return i;
		return -1;
	}
    
    public static int index_of_door(char key) {
		for (int i = 0; i < 6; i++)
			if (key == doorlist[i])
				return i;
		return -1;
	}
    
    private static int BFS(PointM start, int i, int j) {
    	Queue<PointM> queue = new LinkedList<>();		
		queue.add(start);
		visited[start.x][start.y][0] = true;
		
		while (!queue.isEmpty()) {
			PointM now = queue.poll();			 
			for (int k = 0; k < 4; k++) { 
				int x = now.x + dx[k];
				int y = now.y + dy[k];
				
				if (x < 0 || x >= N || y <0 || y >= M) {
					continue;
				}
				if(map[x][y] == '1')
					return now.level + 1;
				if (map[x][y] != '#' && !visited[x][y][now.haskey]) {
					if (map[x][y] == '.') { 
						queue.add(new PointM(x, y, now.level + 1, now.haskey));
						visited[x][y][now.haskey] = true;
					} else if (index_of_key(map[x][y]) > -1) { 
						queue.add(new PointM(x, y, now.level + 1, now.haskey | (32 >> index_of_key(map[x][y]))));
						visited[x][y][now.haskey] = true;
					} else if (index_of_door(map[x][y]) > -1) { 
						int temp = now.haskey & (32 >> index_of_door(map[x][y]));
						if (temp == 0)
							continue;
						queue.add(new PointM(x, y, now.level + 1, now.haskey));
						visited[x][y][now.haskey] = true;
					}
				}
			}
		}
		return -1;
	}
    
    public static void main(String[] args) {
    	input();
    	
    	System.out.println(BFS(start, N, M));    	
    }
    
    static class PointM {
    	int x, y;
    	int level;
    	int haskey;

    	PointM(int x, int y, int level, int haskey) {
    		this.x = x;
    		this.y = y;
    		this.level = level;
    		this.haskey = haskey;
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
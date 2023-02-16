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

public class B17822_원판돌리기 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, M, T;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	T = scan.nextInt();
    	map = new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			map[i][j] = scan.nextInt();
    		}
    	}
    }
    
    
 	static void check(int x, int y, int val) {
 		visited[x][y] = true;
 		for (int i = 0; i < 4; i++) {
 			int px = x + dx[i];
 			int py = y + dy[i];

 			if (py < 0) {
 				py = M - 1;
 			} else if (py >= M) {
 				py = 0;
 			}

 			if (0 <= px && px < N) {
 				if (!visited[px][py] && map[px][py] == val) {
 					flag = true;
 					map[x][y] = -1; 
 					map[px][py] = -1;
 					check(px, py, val); 
 				}
 			}

 		}

 	}
    
    static void updateMap() {
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					sum += map[i][j];
					cnt++;
				}
			}
		}

		float avg = (float) (sum) / cnt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					if (map[i][j] < avg) {
						map[i][j] += 1;
					} else if (map[i][j] > avg) {
						map[i][j] -= 1;
					}
				}
			}
		}
	}
    
    static void move(int x, int d, int k) {
		int tempX = x;
		while (tempX - 1 < N) {
			if (d == 0) { 
				for (int j = 0; j < k; j++) {
					int temp = map[tempX - 1][M - 1];
					for (int i = M - 1; i >= 1; i--) {
						map[tempX - 1][i] = map[tempX - 1][i - 1];
					}
					map[tempX - 1][0] = temp;
				}
			} else if (d == 1) { 
				for (int j = 0; j < k; j++) {
					int temp = map[tempX - 1][0];
					for (int i = 0; i < M - 1; i++) {
						map[tempX - 1][i] = map[tempX - 1][i + 1];
					}
					map[tempX - 1][M - 1] = temp;
				}
			}

			tempX += x;
		}

		flag = false;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] != -1) {
					check(i, j, map[i][j]); 
				}
			}
		}

		if (!flag) { 
			updateMap();
		}
	}
    
    private static void pro() {
		
    	for (int i = 0; i < T; i++) {
    		int x = scan.nextInt();
    		int d = scan.nextInt();
    		int k = scan.nextInt();
    		
    		move(x, d, k);
    	}
    	
    	int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					result += map[i][j];
				}
			}
		} 

		System.out.println(result);
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
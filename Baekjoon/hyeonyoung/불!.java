import java.io.*;
import java.util.*;

// BOJ_4179

class State{
	int x, y;
	boolean isFire;
	
	State(int x, int y, boolean isFire){
		this.x = x;
		this.y = y;
		this.isFire = isFire;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[][] delta = {{-1,0},{1,0},{0,1},{0,-1}};
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());		
		int c = Integer.parseInt(st.nextToken());
		
		char[][] maze = new char[r][c];
		int[][] visit = new int[r][c];
		Queue<State> queue = new LinkedList<>();
		for(int i = 0; i < r; i++) {
			maze[i] = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				if(maze[i][j] == 'J') {
					maze[i][j] = '.';
					visit[i][j] = 1;
					queue.add(new State(i, j, false));
				}
			}
		}
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(maze[i][j] == 'F') {
					queue.add(new State(i, j, true));
				}
			}
		}
		
		boolean escape = false;
		while(!queue.isEmpty()) {
			int a = queue.peek().x, b = queue.peek().y;
			boolean isFire = queue.peek().isFire;
			queue.remove();
			
			if(isFire) { // 불
				for(int k = 0; k < 4; k++)
				{
					int aa = a + delta[k][0];
					int bb = b + delta[k][1];
					
					if(aa < 0 || aa >= r || bb < 0 || bb >= c) {
						continue;
					}
					
					if(maze[aa][bb] == '.') {
						maze[aa][bb] = 'F';
						queue.add(new State(aa, bb, true));
					}
				}
			}
			else { // 지훈이
				if(maze[a][b] == 'F') {
					continue;
				}
				if(a == 0 || a == r-1 || b == 0 || b == c-1) {
					bw.write(Integer.toString(visit[a][b]));
					escape = true;
					break;
				}
				
				for(int k = 0; k < 4; k++)
				{
					int aa = a + delta[k][0];
					int bb = b + delta[k][1];
					
					if(aa < 0 || aa >= r || bb < 0 || bb >= c) {
						continue;
					}

					if(maze[aa][bb] == '.' && visit[aa][bb] == 0) {
						visit[aa][bb] = visit[a][b] + 1;
						queue.add(new State(aa, bb, false));
					}
				}
			}
		}
		
		if(!escape) {
			bw.write("IMPOSSIBLE");
		}
		
		bw.flush();
		bw.close();
	}
}

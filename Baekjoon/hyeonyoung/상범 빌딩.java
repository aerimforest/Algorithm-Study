import java.io.*;
import java.util.*;

// BOJ_6593

class State {
	int x, y, z;
	
	State(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int[][] delta = {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			line = br.readLine().split(" ");
			int l = Integer.parseInt(line[0]);
			int r = Integer.parseInt(line[1]);
			int c = Integer.parseInt(line[2]);
			
			if(l == 0) {
				break;
			}
			
			char[][][] building = new char[l][r][c];
			State start = null;
			for(int i = 0; i < l; i++) {
				for(int j = 0; j < r; j++) {
					building[i][j] = br.readLine().toCharArray();
					for(int k = 0; k < c; k++) {
						if(building[i][j][k] == 'S') {
							building[i][j][k] = '.';
							start = new State(i, j, k);
						}
					}
				}
				br.readLine();
			}
			
			int answer = -1;
			int[][][] visit = new int[l][r][c];
			Queue<State> queue = new LinkedList<>();
			visit[start.x][start.y][start.z] = 1; 
			queue.add(start);
			while(!queue.isEmpty()) {
				int x = queue.peek().x;
				int y = queue.peek().y;
				int z = queue.peek().z;
				queue.remove();
				
				if(building[x][y][z] == 'E') {
					answer = visit[x][y][z]-1;
					break;
				}
				
				for(int k = 0; k < 6; k++) {
					int xx = x + delta[k][0];
					int yy = y + delta[k][1];
					int zz = z + delta[k][2];
					
					if(xx < 0 || xx >= l || yy < 0 || yy >= r || zz < 0 || zz >= c) {
						continue;
					}
					
					if(building[xx][yy][zz] != '#' && visit[xx][yy][zz] == 0) {
						visit[xx][yy][zz] = visit[x][y][z] + 1;
						queue.add(new State(xx, yy, zz));
					}
				}
			}
			if(answer == -1) {
				sb.append("Trapped!\n");
			}
			else {
				sb.append("Escaped in ").append(answer).append(" minute(s).\n");
			}
		}
		System.out.println(sb);
	}
}

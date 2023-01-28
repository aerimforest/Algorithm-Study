import java.io.*;
import java.util.*;

// BOJ_1600

class Pair{
	int x, y, z;
	
	Pair(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int[][] delta = {{-1,0},{1,0},{0,1},{0,-1}};
	static int[][] horse = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int k = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		int w = Integer.parseInt(input[0]);
		int h = Integer.parseInt(input[1]);
		char[][] map = new char[h][w];
		for(int i = 0; i < h; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < w; j++) {
				map[i][j] = input[j].charAt(0);
			}
		}
		
		int answer = -1;
		int[][][] visit = new int[h][w][k+1];
		visit[0][0][0] = 1;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0,0,0));
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int z = q.peek().z;
			q.remove();
			
			if(x == h-1 && y == w-1) {
				answer = visit[x][y][z] - 1;
				break;
			}
			
			// 원숭이 이동
			for(int m = 0; m < 4; m++) {
				int xx = x + delta[m][0];
				int yy = y + delta[m][1];
				
				if(xx < 0 || xx >= h || yy < 0 || yy >= w) {
					continue;
				}
				
				if(map[xx][yy] == '0' && visit[xx][yy][z] == 0) {
					visit[xx][yy][z] = visit[x][y][z] + 1;
					q.add(new Pair(xx, yy, z));
				}
			}
			
			// 말 이동
			if(z+1 <= k) {
				for(int m = 0; m < 8; m++) {
					int xx = x + horse[m][0];
					int yy = y + horse[m][1];
					
					if(xx < 0 || xx >= h || yy < 0 || yy >= w) {
						continue;
					}
					
					if(map[xx][yy] == '0' && visit[xx][yy][z+1] == 0) {
						visit[xx][yy][z+1] = visit[x][y][z] + 1;
						q.add(new Pair(xx, yy, z+1));
					}
				}
			}
		}
		System.out.println(answer);
	}
}

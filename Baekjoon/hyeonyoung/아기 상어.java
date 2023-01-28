import java.io.*;
import java.util.*;

// BOJ_16236

class Fish{
	int x, y, dis;
	
	Fish(int x, int y, int dis){
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}
class Shark{
	int x, y, size, cnt;
	
	Shark(int x, int y, int size, int cnt){
		this.x = x;
		this.y = y;
		this.size = size;
		this.cnt = cnt;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int[][] delta = {{-1,0},{0,-1},{0,1},{1,0}};
		
		int n = Integer.parseInt(br.readLine());
		int[][] space = new int[n][n];
		
		Shark shark = new Shark(0,0,2,0);
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				space[i][j] = Integer.parseInt(input[j]);
				if(space[i][j] == 9) {
					shark.x = i;
					shark.y = j;
					space[i][j] = 0;
				}
			}
		}
		
		int answer = 0;
		while(true) {
			// 물고기 찾기
			int[][] visit = new int[n][n];
			Fish fish = new Fish(-1,-1,100);
			PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {
				@Override
				public int compare(Fish o1, Fish o2) {
					if(o1.dis == o2.dis) {
						if(o1.x == o2.x) {
							return Integer.compare(o1.y, o2.y);
						}
						return Integer.compare(o1.x, o2.x);
					}
					
					return Integer.compare(o1.dis, o2.dis);
				}

			});
			
			visit[shark.x][shark.y] = 1;
			pq.add(new Fish(shark.x, shark.y, 1));
			
			while(!pq.isEmpty()) {
				int x = pq.peek().x;
				int y = pq.peek().y;
				int dis = pq.peek().dis;
				pq.remove();
				
				if(space[x][y] > 0 && space[x][y] < shark.size) {
					fish = new Fish(x, y, dis);
					break;
				}
				
				for(int k = 0; k < 4; k++) {
					int xx = x + delta[k][0];
					int yy = y + delta[k][1];
					
					if(xx < 0 || xx >= n || yy < 0 || yy >= n) {
						continue;
					}
					
					if(space[xx][yy] <= shark.size && visit[xx][yy] == 0) {
						visit[xx][yy] = visit[x][y] + 1;
						pq.add(new Fish(xx, yy, visit[xx][yy]));
					}
				}
			}
			
			if(fish.dis == 100) {
				break;
			}
			
			answer += fish.dis - 1;
			space[fish.x][fish.y] = 0;
			shark.x = fish.x;
			shark.y = fish.y;
			shark.cnt++;
			if(shark.cnt == shark.size) {
				shark.size++;
				shark.cnt = 0;
			}
		}
		
		System.out.println(answer);
	}
}

import java.io.*;
import java.util.*;

// BOJ_22865

class Road{
	Road(int cur, int cost){
		this.cur = cur;
		this.cost = cost;
	}
	int cur, cost;
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// init
		ArrayList<ArrayList<Road>> adj = new ArrayList<ArrayList<Road>>();
		int[][] distance = new int[3][n+1];
		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<Road>());
			distance[0][i] = distance[1][i] = distance[2][i] = Integer.MAX_VALUE;
		}
		
		int[] friends = new int[3];
		String[] line = br.readLine().split(" ");
		for(int i = 0; i < 3; i++) {
			friends[i] = Integer.parseInt(line[i]);
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			line = br.readLine().split(" ");
			int d = Integer.parseInt(line[0]);
			int e = Integer.parseInt(line[1]);
			int l = Integer.parseInt(line[2]);
			
			adj.get(d).add(new Road(e, l));
			adj.get(e).add(new Road(d, l));
		}
		
		// 친구마다 거리 계산
		PriorityQueue<Road> pq = new PriorityQueue<>(new Comparator<Road>() {
			@Override
			public int compare(Road r1, Road r2) {
				if(r1.cost >= r2.cost) {
					return 1;
				}
				return -1;
			}
		});
		for(int f = 0; f < 3; f++) {
			int start = friends[f];
			distance[f][start] = 0;
			pq.clear();
			pq.add(new Road(start, 0));
			while(!pq.isEmpty()) {
				int cur = pq.peek().cur;
				int cost = pq.peek().cost;
				pq.remove();
				
				if(distance[f][cur] != cost) {
					continue;
				}
				
				for(Road next : adj.get(cur)) {
					if(distance[f][next.cur] > cost + next.cost) {
						distance[f][next.cur] = cost + next.cost;
						pq.add(new Road(next.cur, distance[f][next.cur]));
					}
				}
			}
		}
		
//		for(int i = 0; i < 3; i++) {
//			for(int j = 1; j <= n; j++) {
//				System.out.print(distance[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 지역마다 거리 계산
		int d = 0, answer = -1;
		for(int j = 1; j <= n; j++) {
			int tmp = Integer.MAX_VALUE;
			for(int i = 0; i < 3; i++) {
				tmp = Integer.min(tmp, distance[i][j]);
			}
			if(d < tmp) {
				d = tmp;
				answer = j;
			}
		}
		
		System.out.println(answer);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 시간 : 104ms
// 메모리 : 12320KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		List<Integer>[][] nodes = new ArrayList[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				nodes[i][j] = new ArrayList<>();
			}
		}
		int[][] knight = new int[M+1][3];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken())-1;
			knight[i][0] = r;
			knight[i][1] = c;
			knight[i][2] = dir;
			nodes[r][c].add(i);
		}
		
		int time = 1;
		while(move(knight, nodes, map)) {
			time++;
			if(time > 1000) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(time);
	}
	private static boolean move(int[][] knight, List<Integer>[][] nodes, int[][] map) {

		int[] dr = {0,0,-1,1};
		int[] dc = {1,-1,0,0};
		int N = map.length;
		int M = knight.length;
		
		for (int idx = 1; idx < M; idx++) {
			int r = knight[idx][0];
			int c = knight[idx][1];
			int dir = knight[idx][2];
			
			int n = find_idx_in_nodes(nodes[r][c], idx);
			if(n == -1) continue;
			
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr >= N || nc >= N || nr < 0 || nc < 0 || map[nr][nc] == 2) {
				if(dir == 0) {
					dir = 1;
				} else if(dir == 1) {
					dir = 0;
				} else if(dir == 2) {
					dir = 3;
				} else {
					dir = 2;
				}
				nr = r + dr[dir];
				nc = c + dc[dir];
                knight[idx][2] = dir;
				if(nr >= N || nc >= N || nr < 0 || nc < 0 || map[nr][nc] == 2) continue;
			}
			if(map[nr][nc] == 0) {
				for (int i = n; i < nodes[r][c].size(); i++) {
					knight[nodes[r][c].get(i)][0] = nr;
					knight[nodes[r][c].get(i)][1] = nc;
					nodes[nr][nc].add(nodes[r][c].get(i));
				}
				if(nodes[nr][nc].size() >= 4) return false;
				for (int i = nodes[r][c].size()-1; i >= n; i--) {
					nodes[r][c].remove(i);
				}
			} else if(map[nr][nc] == 1) {
				for (int i = nodes[r][c].size()-1; i >= n; i--) {
					knight[nodes[r][c].get(i)][0] = nr;
					knight[nodes[r][c].get(i)][1] = nc;
					nodes[nr][nc].add(nodes[r][c].get(i));
					if(nodes[nr][nc].size() >= 4) return false;
					nodes[r][c].remove(i);
				}
			}
		}
		return true;
	}
	private static int find_idx_in_nodes(List<Integer> node, int idx) {

		for (int i = 0; i < node.size(); i++) {
			if(node.get(i) == idx) {
				return i;
			}
		}
		return -1;
	}


}

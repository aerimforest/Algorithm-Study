package _202209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR_골드4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int origin = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			
			// dfs로 돌리면 평생 돌아갈 수도 있음
			// 얘를 어케 bfs로 돌리지;
			
			Queue<Integer> que = new LinkedList<>();
			que.offer(origin);
			String[] map = new String[10000];
			map[origin] = "";
			while(!que.isEmpty()) {
				int cur = que.poll();
				if(cur == dest) {
//					System.out.println(cur + " "+ dest);
					break;
				}
				
				// D
				int tmp = (cur << 1) % 10000;
				if(map[tmp] == null) {
//					System.out.println("D"+ tmp);
					map[tmp] = map[cur]+"D";
					que.offer(tmp);
				}
				
				// S
				tmp = cur - 1;
				if(tmp == -1) tmp = 9999;
				if(map[tmp] == null) {
//					System.out.println("S"+ tmp);
					map[tmp] = map[cur]+"S";
					que.offer(tmp);
				}
				
				// L
				tmp = (cur % 1000) * 10 + (cur / 1000);
				if(map[tmp] == null) {
//					System.out.println("L"+ tmp);
					map[tmp] = map[cur]+"L";
					que.offer(tmp);
				}
				
				// R
				tmp = (cur % 10) * 1000 + cur / 10;
				if(map[tmp] == null) {
//					System.out.println("R"+ tmp);
					map[tmp] = map[cur]+"R";
					que.offer(tmp);
				}
			}
			System.out.println(map[dest]);
		}
	}

}

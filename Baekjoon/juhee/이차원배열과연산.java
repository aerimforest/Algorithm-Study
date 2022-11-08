import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 : 172ms
// 메모리 : 31448KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken())-1;
		int C = Integer.parseInt(st.nextToken())-1;
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[100][100];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] rc = new int[2];
		rc[0] = 3;
		rc[1] = 3;
		int time = 0;
		while(map[R][C] != K && time <= 100) {
			if(rc[0] >= rc[1]) {
				map = op_R(map, rc);
			} else {
				map = op_C(map, rc);
			}
			
			time++;
		}
		if(time == 101) System.out.println(-1);
		else System.out.println(time);
	}

	private static int[][] op_C(int[][] map, int[] rc) {

		int[][] tmp = new int[100][100];
		int r = 0;
		for (int j = 0; j < 100; j++) {
			PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] != o2[1]) return o1[1] - o2[1];
					return o1[0] - o2[0];
				}
			});
			int[] num = new int[101];
			for (int i = 0; i < 100; i++) {
				if(map[i][j] == 0) continue;
				num[map[i][j]]++;
			}
			for (int i = 0; i < 101; i++) {
				if(num[i] == 0) continue;
				que.offer(new int[] {i, num[i]});
			}
			
			for (int i = 0; i < 100; i+=2) {
				if(que.isEmpty()) break;
				int[] cur = que.poll();
				tmp[i][j] = cur[0];
				tmp[i+1][j] = cur[1];
				if(i+1 > r) r = i+1;
			}
		}
		rc[0] = r;
		return tmp;
	}

	private static int[][] op_R(int[][] map, int[] rc) {

		int[][] tmp = new int[100][100];
		int c = 0;
		for (int i = 0; i < 100; i++) {
			PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] != o2[1]) return o1[1] - o2[1];
					return o1[0] - o2[0];
				}
			});
			int[] num = new int[101];
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 0) continue;
				num[map[i][j]]++;
			}
			for (int j = 0; j < 101; j++) {
				if(num[j] == 0) continue;
				que.offer(new int[] {j, num[j]});
			}
			
			for (int j = 0; j < 100; j+=2) {
				if(que.isEmpty()) break;
				int[] cur = que.poll();
				tmp[i][j] = cur[0];
				tmp[i][j+1] = cur[1];
				if(j+1 > c) c = j+1;
			}
		}
		rc[1] = c;
		return tmp;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int max;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MAX_VALUE;
		int[] num = new int[6];
		Arrays.fill(num, 5);
		dfs(0, num, map);
		if(max == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(max);
	}

	private static void dfs(int cnt, int[] num, int[][] map) {
		
		if(max < cnt) return;
		int N = map.length;
		int[][] tmp = new int[10][10];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[i][j];
				if(map[i][j] == 1) flag = true;
			}
		}
		if(!flag) {
			max = Math.min(max, cnt);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(tmp[i][j] == 1) {
					for (int k = 5; k >= 0; k--) {
						if(num[k] == 0) continue;
						if(check(i, j, k, tmp)) {
							fill_tmp(i, j, k, tmp, 0);
							num[k]--;
							dfs(cnt+1, num, tmp);
							num[k]++;
							fill_tmp(i, j, k, tmp, 1);
						}
					}
				}
			}
		}
	}

	private static void fill_tmp(int r, int c, int k, int[][] tmp, int num) {
		
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				int nr = r + i;
				int nc = c + j;
				tmp[nr][nc] = num; 
			}
		}
	}

	private static boolean check(int r, int c, int k, int[][] tmp) {

		int N = tmp.length;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				int nr = r + i;
				int nc = c + j;
				if(nr >= N || nc >= N || nr < 0 || nc < 0) return false;
				if(tmp[nr][nc] == 0) return false;
			}
		}
		return true;
	}

}

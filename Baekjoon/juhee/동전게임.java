import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 184ms
// 메모리 : 27104KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			boolean[][] map = new boolean[3][3];
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					map[i][j] = st.nextToken().charAt(0) == 'H' ? true : false;
				}
			}
			int[] ver = new int[(int)Math.pow(2, 9)];
			Arrays.fill(ver, 987654321);
			min = Integer.MAX_VALUE;
			dfs(map, 0, ver);
			if(min == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(min);
		}
	}

	static int min;
	private static void dfs(boolean[][] map, int cnt, int[] ver) {

		if(cnt >= min) return;
		boolean[][] tmp = new boolean[3][3];
		int flag = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tmp[i][j] = map[i][j];
				if(map[i][j]) flag |= (1 << (i * 3 + j));
			}
		}
		if(flag == 0 || flag == 511) {
			min = Math.min(min, cnt);
			return;
		}
		if(ver[flag] <= cnt) {
			return;
		}
		ver[flag] = cnt;
		
		for (int i = 0; i < 3; i++) {
			tmp[i][0] = !tmp[i][0];
		}
		dfs(tmp, cnt+1, ver);
		for (int i = 0; i < 3; i++) {
			tmp[i][0] = !tmp[i][0];
		}
		for (int i = 0; i < 3; i++) {
			tmp[i][1] = !tmp[i][1];
		}
		dfs(tmp, cnt+1, ver);
		for (int i = 0; i < 3; i++) {
			tmp[i][1] = !tmp[i][1];
		}
		for (int i = 0; i < 3; i++) {
			tmp[i][2] = !tmp[i][2];
		}
		dfs(tmp, cnt+1, ver);
		for (int i = 0; i < 3; i++) {
			tmp[i][2] = !tmp[i][2];
		}
		for (int i = 0; i < 3; i++) {
			tmp[0][i] = !tmp[0][i];
		}
		dfs(tmp, cnt+1, ver);
		for (int i = 0; i < 3; i++) {
			tmp[0][i] = !tmp[0][i];
		}
		for (int i = 0; i < 3; i++) {
			tmp[1][i] = !tmp[1][i];
		}
		dfs(tmp, cnt+1, ver);
		for (int i = 0; i < 3; i++) {
			tmp[1][i] = !tmp[1][i];
		}
		for (int i = 0; i < 3; i++) {
			tmp[2][i] = !tmp[2][i];
		}
		dfs(tmp, cnt+1, ver);
		for (int i = 0; i < 3; i++) {
			tmp[2][i] = !tmp[2][i];
		}
		for (int i = 0; i < 3; i++) {
			tmp[i][i] = !tmp[i][i];
		}
		dfs(tmp, cnt+1, ver);
		for (int i = 0; i < 3; i++) {
			tmp[i][i] = !tmp[i][i];
		}
		for (int i = 0; i < 3; i++) {
			tmp[2-i][i] = !tmp[2-i][i];
		}
		dfs(tmp, cnt+1, ver);
		for (int i = 0; i < 3; i++) {
			tmp[2-i][i] = !tmp[2-i][i];
		}
	}
	

}

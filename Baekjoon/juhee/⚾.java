import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 428ms
// 메모리 : 76640KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] score = new int[N][10];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] num = new int[9];
		num[3] = 1;
		boolean[] v = new boolean[10];
		v[1] = true;
		max = 0;
		perm(0, v, num, score);
		System.out.println(max);
	}

	static int max;
	private static void perm(int cnt, boolean[] v, int[] num, int[][] score) {

		if(cnt == 3) {
			num[cnt] = 1;
			perm(cnt+1, v, num, score);
		}
		if(cnt == 9) {
			int N = score.length;
			int total = 0;
			int o = 0;
			for (int i = 0; i < N; i++) {
				int[] base = new int[3];
				int out = 0;
				while(out < 3) {
					if(score[i][num[o]] == 0) out++;
					else if(score[i][num[o]] == 1) {
						if(base[2] == 1) total++;
						base[2] = base[1];
						base[1] = base[0];
						base[0] = 1;
					} else if(score[i][num[o]] == 2) {
						total += base[2] + base[1];
						base[2] = base[0];
						base[1] = 1;
						base[0] = 0;
					} else if(score[i][num[o]] == 3) {
						total += base[2] + base[1] + base[0];
						base[2] = 1;
						base[1] = 0;
						base[0] = 0;
					} else {
						total += base[2] + base[1] + base[0] + 1;
						base[2] = 0;
						base[1] = 0;
						base[0] = 0;
					}
					o++;
					if(o == 9) o = 0;
				}
			}
			max = Math.max(max, total);
			return;
		}
		
		for (int i = 2; i <= 9; i++) {
			if(v[i]) continue;
			v[i] = true;
			num[cnt] = i;
			perm(cnt+1, v, num, score);
			v[i] = false;
		}
	}

}

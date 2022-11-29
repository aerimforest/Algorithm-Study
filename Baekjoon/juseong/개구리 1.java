import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, frog[][], like[][], tree[][];
	static int sel[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		frog = new int[N][4];
		like = new int[N][2];
		tree = new int[M][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 4; j++) {
				frog[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			like[i][0] = Integer.parseInt(st.nextToken()) - 1;
			like[i][1] = Integer.parseInt(st.nextToken()) - 1;
			if (like[i][0] == like[i][1])
				like[i][1] = -1;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 3; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		String ans = "NO";
		sel = new int[N];
		visit = new boolean[N];
		dfs(0);
		System.out.println(ans);
	}


	private static void dfs(int idx) {
		if (idx == N) {
			if (check()) {
				
			return;
		}

		for (int j = 0; j < 2; j++) {
			if (like[idx][j] == -1)
				continue;
			int num = like[idx][j];
			if (!visit[num]) {
				visit[num] = true;
				sel[num] = idx;
				dfs(idx + 1);
				visit[num] = false;
			}
		}

	}

	private static boolean check() {
		
}
